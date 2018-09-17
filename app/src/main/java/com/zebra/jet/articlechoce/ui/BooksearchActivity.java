package com.zebra.jet.articlechoce.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.kymjs.rxvolley.RxVolley;
import com.kymjs.rxvolley.client.HttpCallback;
import com.zebra.jet.articlechoce.R;
import com.zebra.jet.articlechoce.adapter.BooksearchAdapter;
import com.zebra.jet.articlechoce.data.BookData;
import com.zebra.jet.articlechoce.util.L;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jet on 2018-09-17.
 */

public class BooksearchActivity extends BaseActivity implements View.OnClickListener{
    private BaseAdapter mAdapter;
    private EditText et_phone;
    private Button bt_phone;
    private ListView list_phone;
    private ListView mListView;

    private List<BookData> mList = new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.book_search);
        initView();
    }
    //初始化
    private void initView() {//修改
        et_phone = (EditText) findViewById(R.id.et_phone);
        bt_phone = (Button) findViewById(R.id.bt_phone);
        bt_phone.setOnClickListener(this);
        list_phone = (ListView) findViewById(R.id.list_phone);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_phone:
                mListView = (ListView) v.findViewById(R.id.list_phone);
                mList.clear();
                //get
                String number = et_phone.getText().toString().trim();
                String url = "https://api.douban.com/v2/book/search?q="+number;
                //是否为空
                if(!TextUtils.isEmpty(number)){
                    RxVolley.get(url, new HttpCallback() {
                        @Override
                        public void onSuccess(String t) {
                            //Toast.makeText(BooksearchActivity.this,t,Toast.LENGTH_SHORT).show();
                            L.i("json:"+t);
                            parsingJson(t);
                        }
                    });
                }else{
                    Toast.makeText(this,"输入框不得为空",Toast.LENGTH_SHORT).show();
                }

                break;
        }
    }
    //解析数据
    private void parsingJson(String t) {
        try {
            JSONObject jsonObject = new JSONObject(t);
            JSONArray jsonArray = jsonObject.getJSONArray("books");

            for (int i = 0; i< jsonArray.length();i++){
                JSONObject json = (JSONObject) jsonArray.get(i);

                BookData data = new BookData();
                String url = json.getString("image");
                data.setTitle(json.getString("title"));
                data.setAverage(json.getJSONObject("rating").getString("average"));
                data.setAuthor(json.getString("author"));
                data.setPrice(json.getString("price"));
                data.setSummary(json.getString("summary"));
                data.setImage(url);
                mList.add(data);

            }
            BooksearchAdapter adapter = new BooksearchAdapter(this,mList);
            list_phone.setAdapter(adapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}

