package com.zebra.jet.articlechoce.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.youth.banner.Banner;
import com.zebra.jet.articlechoce.R;
import com.zebra.jet.articlechoce.adapter.HomeAdapter;
import com.zebra.jet.articlechoce.data.MovData;
import com.zebra.jet.articlechoce.util.GlideImageLoader;
import com.zebra.jet.articlechoce.util.L;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jet on 2018-09-15.
 */

public class HomeFragment extends Fragment{

    private ListView mListView;
    private List<MovData> mList = new ArrayList<>();
    Banner banner;
    public static HomeFragment newInstance(String name){
        Bundle args = new Bundle();
        args.putString("name", name);
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home,null);
        findView(view);
        return view;
    }

    private void findView(View view) {
        mListView = (ListView) view.findViewById(R.id.mListView);
        mList.clear();
        //port 警报
        String url = "https://api.douban.com/v2/movie/in_theaters";//豆瓣电影
        RxVolley.get(url, new HttpCallback() {
            @Override
            public void onSuccess(String t) {
                //Toast.makeText(getActivity(),t, Toast.LENGTH_SHORT).show();
                parsingJson(t);
                L.i("json:"+t);
            }
        });
    }
    //解析Json
    private void parsingJson(String t) {
        try {
            JSONObject jsonObject = new JSONObject(t);
            JSONArray jsonList = jsonObject.getJSONArray("subjects");

            for (int i = 0; i<jsonList.length();i++){
                JSONObject json = (JSONObject) jsonList.get(i);
                MovData data = new MovData();

                String title = json.getString("title");

                data.setTitle(json.getString("title"));
                data.setAverage(json.getJSONObject("rating").getString("average"));
                data.setGenres(json.getString("genres"));
                data.setYear(json.getString("year"));
                data.setMedium(json.getJSONObject("images").getString("medium"));
                mList.add(data);
            }
            HomeAdapter adapter = new HomeAdapter(getActivity(),mList);
            mListView.setAdapter(adapter);
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
