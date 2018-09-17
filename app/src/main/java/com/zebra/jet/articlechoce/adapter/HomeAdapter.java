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
import com.zebra.jet.articlechoce.data.MovData;
import com.zebra.jet.articlechoce.util.PicassoUtils;

import java.util.List;

/**
 * Created by jet on 2018-09-16.
 */

public class HomeAdapter extends BaseAdapter {
    private Context mContext;
    private List<MovData> mList;
    private MovData data;
    private LayoutInflater inflater;

    private WindowManager windowManager;
    private int width;

    public HomeAdapter(Context mContext, List<MovData> mList){
        this.mContext = mContext;
        this.mList = mList;
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
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(R.layout.item_movie1,null);
            viewHolder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            viewHolder.tv_average = (TextView) convertView.findViewById(R.id.tv_average);
            viewHolder.tv_genres = (TextView) convertView.findViewById(R.id.tv_genres);
            viewHolder.tv_year = (TextView) convertView.findViewById(R.id.tv_year);
            viewHolder.iv =(ImageView) convertView.findViewById(R.id.iv);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        data = mList.get(position);

        String iv = data.getMedium();
        viewHolder.tv_title.setText(data.getTitle());
        viewHolder.tv_average.setText(data.getAverage());
        viewHolder.tv_genres.setText(data.getGenres());
        viewHolder.tv_year.setText(data.getYear());

        //指定大小
        PicassoUtils.loadImageViewSize(mContext,iv,viewHolder.iv,width/3,500);
        return convertView;
    }


    class ViewHolder{
        private TextView tv_title;//电影名
        private TextView tv_average;//评级
        private TextView tv_genres;//类型
        private TextView tv_year;//上映时间
        private ImageView iv;//图片
    }
}
