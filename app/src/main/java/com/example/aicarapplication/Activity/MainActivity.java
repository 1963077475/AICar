package com.example.aicarapplication.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.aicarapplication.R;
import com.example.aicarapplication.adapter.BottomAdapter;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView title;
    private ViewPager viewPager;
    private BottomNavigationView navigationView;
    private ArrayList<Fragment> fragments=new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    private void initView() {
        title = findViewById(R.id.title);
        viewPager=findViewById(R.id.vp);
        navigationView=findViewById(R.id.bn);
        navigationView.setLabelVisibilityMode(1);
        fragments.add(new IndexFragment());
        fragments.add(new HardwareActivity());
        BottomAdapter adapter=new BottomAdapter(getSupportFragmentManager(),this,fragments);
        viewPager.setAdapter(adapter);
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.item1:
                        viewPager.setCurrentItem(0);
                        return true;
                    case R.id.item2:
                        viewPager.setCurrentItem(1);
                        return true;
                }
                return false;
            }
        });


    }
}
