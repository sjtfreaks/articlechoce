package com.zebra.jet.articlechoce.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.youth.banner.Banner;
import com.zebra.jet.articlechoce.MainActivity;
import com.zebra.jet.articlechoce.R;
import com.zebra.jet.articlechoce.ui.BooksearchActivity;
import com.zebra.jet.articlechoce.util.GlideImageLoader;

import java.util.ArrayList;
import java.util.List;

import ru.katso.livebutton.LiveButton;

/**
 * Created by jet on 2018-09-15.
 */

public class NewbookFragment extends Fragment implements View.OnClickListener{
    LiveButton bt_search;
    LiveButton bt_book;
    Banner banner;
    public static NewbookFragment newInstance(String name){
        Bundle args = new Bundle();
        args.putString("name", name);
        NewbookFragment fragment = new NewbookFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_newbook,null);
        initView(view);
        return view;
    }

    private void initView(View view) {
        banner = (Banner) view.findViewById(R.id.banner1);
        //本地图片数据（资源文件）
        List<Integer> list=new ArrayList<>();
        list.add(R.mipmap.b1);
        list.add(R.mipmap.b2);
        list.add(R.mipmap.b3);
        banner.setImages(list)
                .setImageLoader(new GlideImageLoader())
                .start();


        bt_search = (LiveButton) view.findViewById(R.id.bt_search);
        bt_search.setOnClickListener(this);
        bt_book = (LiveButton) view.findViewById(R.id.bt_book);
        bt_book.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_search:
                startActivity(new Intent(getActivity(),BooksearchActivity.class));
                break;
        }
    }
}
