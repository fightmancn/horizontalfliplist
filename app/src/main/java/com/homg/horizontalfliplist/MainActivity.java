package com.homg.horizontalfliplist;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.homg.horizontalfliplist.effect.DepthPageTransformer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Homgwu
 */
public class MainActivity extends Activity {

    private ViewPager mViewPager;
    private MainViewPagerAdapter mViewPagerAdapter;
    private List<ItemEntity> mItemEntityList=new ArrayList<ItemEntity>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView(){
        mViewPager= (ViewPager) findViewById(R.id.main_vp);
        initData();
        mViewPagerAdapter=new MainViewPagerAdapter(mItemEntityList,this);
        //设置翻页动画
        mViewPager.setPageTransformer(true,new DepthPageTransformer());
        mViewPager.setAdapter(mViewPagerAdapter);
    }

    /**
     * 初始化数据
     */
    private void initData(){
        for (int i=0;i<104;i++){
            ItemEntity itemEntity=new ItemEntity();
            itemEntity.name="Android"+i;
            mItemEntityList.add(itemEntity);
        }
    }

}
