package com.example.aicarapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.aicarapplication.R;
import com.example.aicarapplication.pojo.NewsBean;
import com.google.gson.Gson;

public class NewsActivity extends AppCompatActivity {
    private TextView newsTitle,newsFirst,newsLast;
    private ImageView newImage;
    private Toolbar toolbar;
    private NewsBean newsBean;
    private TextView title;


    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        setIntent(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initView();
        initData();

    }
    private void initView(){
        newsTitle=findViewById(R.id.news_title);
        newsFirst=findViewById(R.id.news_first);
        newsLast=findViewById(R.id.news_last);
        String newsBeanJson= getIntent().getStringExtra("data");
        newsBean=new Gson().fromJson(newsBeanJson,NewsBean.class);
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        title=findViewById(R.id.title);
        title.setText("新纪要闻");

    }
    private void initData(){
        newsTitle.setText(newsBean.getNewTitle());
        newsFirst.setText(newsBean.getNewsContent());

    }
}