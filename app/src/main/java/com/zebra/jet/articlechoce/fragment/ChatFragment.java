package com.zebra.jet.articlechoce.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ms.square.android.expandabletextview.ExpandableTextView;
import com.zebra.jet.articlechoce.R;
import com.zebra.jet.articlechoce.adapter.SampleTextListAdapter;

/**
 * Created by jet on 2018-09-15.
 */

public class ChatFragment extends Fragment {

    public static ChatFragment newInstance(String name){
        Bundle args = new Bundle();
        args.putString("name", name);
        ChatFragment fragment = new ChatFragment();
        fragment.setArguments(args);
        return fragment;
    }


    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat,null);
        View rootView = inflater.inflate(R.layout.fragment_chat, container, false);

        ((TextView) rootView.findViewById(R.id.sample1).findViewById(R.id.title)).setText("连绵的城市");
        ((TextView) rootView.findViewById(R.id.sample2).findViewById(R.id.title)).setText("御旨 -- 卡夫卡");
        ((TextView) rootView.findViewById(R.id.sample3).findViewById(R.id.title)).setText("寻人海报上的孩子 -- 恰克·帕拉尼克");
        ((TextView) rootView.findViewById(R.id.sample4).findViewById(R.id.title)).setText("裸泳 -- 伊塔洛·卡尔维诺");
        ((TextView) rootView.findViewById(R.id.sample5).findViewById(R.id.title)).setText("春天 -- 吴念真");
        ((TextView) rootView.findViewById(R.id.sample6).findViewById(R.id.title)).setText("打破浪漫病 -- 胡适");
        ((TextView) rootView.findViewById(R.id.sample7).findViewById(R.id.title)).setText("阑尾 -- 余华");
        ((TextView) rootView.findViewById(R.id.sample8).findViewById(R.id.title)).setText("书的魔力 -- 黑塞");
        ExpandableTextView expTv1 = (ExpandableTextView) rootView.findViewById(R.id.sample1)
                .findViewById(R.id.expand_text_view);
        ExpandableTextView expTv2 = (ExpandableTextView) rootView.findViewById(R.id.sample2)
                .findViewById(R.id.expand_text_view);
        ExpandableTextView expTv3 = (ExpandableTextView) rootView.findViewById(R.id.sample3)
                .findViewById(R.id.expand_text_view);
        ExpandableTextView expTv4 = (ExpandableTextView) rootView.findViewById(R.id.sample4)
                .findViewById(R.id.expand_text_view);
        ExpandableTextView expTv5 = (ExpandableTextView) rootView.findViewById(R.id.sample5)
                .findViewById(R.id.expand_text_view);
        ExpandableTextView expTv6 = (ExpandableTextView) rootView.findViewById(R.id.sample6)
                .findViewById(R.id.expand_text_view);
        ExpandableTextView expTv7 = (ExpandableTextView) rootView.findViewById(R.id.sample7)
                .findViewById(R.id.expand_text_view);
        ExpandableTextView expTv8 = (ExpandableTextView) rootView.findViewById(R.id.sample8)
                .findViewById(R.id.expand_text_view);


        expTv1.setOnExpandStateChangeListener(new ExpandableTextView.OnExpandStateChangeListener() {
            @Override
            public void onExpandStateChanged(TextView textView, boolean isExpanded) {
                Toast.makeText(getActivity(), isExpanded ? "Expanded" : "连接成功", Toast.LENGTH_SHORT).show();
            }
        });

        expTv1.setText(getString(R.string.dummy_text1));
        expTv2.setText(getString(R.string.dummy_text2));
        expTv3.setText(getString(R.string.dummy_text3));
        expTv4.setText(getString(R.string.dummy_text4));
        expTv5.setText(getString(R.string.dummy_text5));
        expTv6.setText(getString(R.string.dummy_text6));
        expTv7.setText(getString(R.string.dummy_text7));
        expTv8.setText(getString(R.string.dummy_text8));


        return rootView;
    }

}

