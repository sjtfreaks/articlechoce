package com.zebra.jet.articlechoce;

import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.zebra.jet.articlechoce.adapter.ViewPagerAdapter;
import com.zebra.jet.articlechoce.fragment.ChatFragment;
import com.zebra.jet.articlechoce.fragment.HomeFragment;
import com.zebra.jet.articlechoce.fragment.NewbookFragment;
import com.zebra.jet.articlechoce.fragment.UserFragment;
import com.zebra.jet.articlechoce.util.BottomNavigationViewHelper;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    private ViewPager mViewPager;
    private ViewPagerAdapter viewPagerAdapter;
    private MenuItem menuItem;
    private List<Fragment> mFragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomView);
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        //取消效果
        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
        mViewPager = (ViewPager) findViewById(R.id.vp);mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener(){


            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (menuItem != null) {
                    menuItem.setChecked(false);
                } else {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                menuItem = bottomNavigationView.getMenu().getItem(position);
                menuItem.setChecked(true);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(viewPagerAdapter);
        mFragment = new ArrayList<>();
        mFragment.add(HomeFragment.newInstance("首页"));
        mFragment.add(NewbookFragment.newInstance("新书推荐"));
        mFragment.add(ChatFragment.newInstance("读书评价"));
        mFragment.add(UserFragment.newInstance("个人中心"));
        viewPagerAdapter.setList(mFragment);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(MenuItem item) {
            menuItem = item;
            switch (item.getItemId()) {
                case R.id.home:
                    mViewPager.setCurrentItem(0);
                    return true;
                case R.id.newbook:
                    mViewPager.setCurrentItem(1);
                    return true;
                case R.id.chat:
                    mViewPager.setCurrentItem(2);
                    return true;
                case R.id.user:
                    mViewPager.setCurrentItem(3);
                    return true;
            }
            return false;
        }
    };

}