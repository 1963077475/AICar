package com.example.aicarapplication.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.aicarapplication.R;
import com.example.aicarapplication.adapter.ContentRecycleViewAdapter;
import com.example.aicarapplication.adapter.ItemRecycleViewAdapter;
import com.example.aicarapplication.pojo.ContentBean;
import com.example.aicarapplication.pojo.ItemBean;

import java.util.ArrayList;
import java.util.List;

public class IndexFragment extends Fragment{

    private RecyclerView recycleView_item,recyclerView_content;
    private LinearLayoutManager manager;
    private String[] titles=new String[]{"预防措施","疫情科普","疫情统计"};
    private int[] bgColor = new int[]{R.drawable.map, R.drawable.news, R.drawable.count};
    private String[] contentTitles=new String[]{"2020年9月13日0时至24时："};
    private String[] content=new String[]{"山东无本地住院疑似病例、确诊病例。累计报告确诊病例763例，死亡7例，治愈出院756例。山东无新增境外输入疑似病例、确诊病例。累计报告境外输入确诊病例68例，累计治愈出院57例。山东无新增无症状感染者。正在隔离观察治疗的无症状感染者12例（均为境外输入），出院3例。目前共追踪到密切接触者25071人，尚有204人正在接受医学隔离观察。"};


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        replaceFragment(new GuideFragment());
    }


    public IndexFragment() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.index, container, false);
        // todo 主页菜单的RecycleView
        recycleView_item=view.findViewById(R.id.recycle_view_item);
        recycleView_item.setLayoutManager(new StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL));
        List<ItemBean> itemBeans=new ArrayList<>();
        for(int i=0;i<titles.length;i++){
            ItemBean bean=new ItemBean();
            bean.setItemName(titles[i]);
            bean.setItemImage(bgColor[i]);
            itemBeans.add(bean);
        }
        ItemRecycleViewAdapter adapter=new ItemRecycleViewAdapter(itemBeans);
        recycleView_item.setAdapter(adapter);
        // todo 主页菜单下的RecycleView
        recyclerView_content=view.findViewById(R.id.recycle_view_content_);
        LinearLayoutManager manager=new LinearLayoutManager(getContext());
        recyclerView_content.setLayoutManager(manager);
        List<ContentBean> contentBeans=new ArrayList<>();
        for(int i=0;i<content.length;i++){
            ContentBean contentBean=new ContentBean();
            contentBean.setContentImage(R.mipmap.empty_holo);
            contentBean.setContentTitle(contentTitles[i]);
            contentBean.setContent(content[i]);
            contentBeans.add(contentBean);
        }
        ContentRecycleViewAdapter contentRecycleViewAdapter=new ContentRecycleViewAdapter(contentBeans);
        recyclerView_content.setAdapter(contentRecycleViewAdapter);
        return view;
    }
    private void replaceFragment(Fragment fragment){
        FragmentManager fragmentManager = getChildFragmentManager();//这里获取碎片管理器的方法不同于碎片中嵌套碎片这里使用的是getSupportFragmentManager（）  注：貌似这里亦可以用getFragmentManager（）
        FragmentTransaction transaction = fragmentManager.beginTransaction();//开启一个事物，通过调用beginTransaction（）开启
        transaction.replace(R.id.banner,fragment);//向容器内替换碎片（添加用.add）  第一个参数：容器id  第二个参数：待添加的碎片
        transaction.commit();//提交事务
    }
}
