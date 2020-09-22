package com.example.aicarapplication.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.viewpager.widget.PagerAdapter;

import java.util.List;

public class GuidePageAdapter extends PagerAdapter {
    private List<View> viewList;

    public GuidePageAdapter(List<View> viewList) {
        this.viewList = viewList;
    }

    @Override
    public int getCount() {
        //设置轮播最大值 等于无限循环
        return Integer.MAX_VALUE;
    }

    /**
     * 判断对象是否生成对象
     * @param view
     * @param object
     * @return
     */
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {

        return view==object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        // 当前要显示的数据索引为集合长度
        int newPosition=position%viewList.size();
        container.addView(viewList.get(newPosition));
        return viewList.get(newPosition);

    }
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        //第三处修改，移除的索引为集合的长度
        int newPosition = position % viewList.size();
        container.removeView(viewList.get(newPosition));
    }

}
