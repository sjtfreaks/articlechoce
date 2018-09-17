package com.zebra.jet.articlechoce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zebra.jet.articlechoce.R;
import com.zebra.jet.articlechoce.data.BookData;
import com.zebra.jet.articlechoce.util.PicassoUtils;

import java.util.List;

/**
 * Created by jet on 2018-09-17.
 */

public class BooksearchAdapter extends BaseAdapter {
    private Context mContext;
    private List<BookData> mList;
    private BookData data;
    //加载
    private LayoutInflater inflater;
    private WindowManager windowManager;
    private int width;
    public BooksearchAdapter(Context mContext,List<BookData> mList){
        this.mContext = mContext;
        this.mList = mList;
        //获取系统服务
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        //get系统服务
        windowManager = (WindowManager) mContext.getSystemService(Context.WINDOW_SERVICE);
        //获取屏幕宽度
        width = windowManager.getDefaultDisplay().getWidth();
    }
    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null){
            viewHolder = new BooksearchAdapter.ViewHolder();
            convertView = inflater.inflate(R.layout.item_book,null);
            viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.tv_average = (TextView) convertView.findViewById(R.id.tv_average);
            viewHolder.tv_author = (TextView) convertView.findViewById(R.id.tv_author);
            viewHolder.tv_price = (TextView) convertView.findViewById(R.id.tv_price);
            viewHolder.tv_summary = (TextView) convertView.findViewById(R.id.tv_summary);
            viewHolder.iv =(ImageView) convertView.findViewById(R.id.iv);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        data = mList.get(position);

        String iv = data.getImage();
        viewHolder.tv_title.setText(data.getTitle());
        viewHolder.tv_average.setText(data.getAverage());
        viewHolder.tv_author.setText(data.getAuthor());
        viewHolder.tv_price.setText(data.getPrice());
        viewHolder.tv_summary.setText(data.getSummary());

        //指定大小
        PicassoUtils.loadImageViewSize(mContext,iv,viewHolder.iv,width/3,500);
        return convertView;
    }
    class ViewHolder{
        private TextView tv_title;
        private TextView tv_average;
        private TextView tv_author;
        private TextView tv_price;
        private TextView tv_summary;
        private ImageView iv;//图片

    }
}
