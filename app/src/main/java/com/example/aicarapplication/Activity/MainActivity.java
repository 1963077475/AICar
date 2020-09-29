package com.example.aicarapplication.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentTransaction;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.aicarapplication.R;
import com.example.aicarapplication.data.ApiConfig;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import de.hdodenhof.circleimageview.CircleImageView;

@RequiresApi(api = Build.VERSION_CODES.M)
public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener{

   private Toolbar toolbar;
   private DrawerLayout drawerLayout;
   private IndexFragment indexFragment;
   private HardwareActivity hardwareActivity;
   private EnvFragment envFragement;
   private BottomNavigationView bottom_navigation;
   private NavigationView navigationView;
   private TextView title,userName;

   private final static int FRAGMENT_MAIN=0;
   private final static int FRAGMENT_CRATIVE=1;
   private final static int FRAGMENT_ENV=2;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        showFragment(FRAGMENT_MAIN);
    }

    @Override
    protected void onStart() {
        super.onStart();
        userName=findViewById(R.id.loginText);
        if(ApiConfig.UserName!=null){
            userName.setText(ApiConfig.UserName);
        }else {
           // userName.setText("点击头像登录");
        }
    }

    private void initView(){
        toolbar=findViewById(R.id.toolbar);
        drawerLayout=findViewById(R.id.drawer_layout);
        bottom_navigation=findViewById(R.id.bottom_navigation);
        navigationView=findViewById(R.id.nav_view);
        title=findViewById(R.id.title);


        CircleImageView imageView = navigationView.getHeaderView(0).findViewById(R.id.circleImage);
        setSupportActionBar(toolbar);
        imageView.setOnClickListener(this);

        /*设置选择item监听*/
       navigationView.setNavigationItemSelectedListener(this);



    }
    private void showFragment(int index){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        hideFragment(fragmentTransaction);
        switch (index) {
            case FRAGMENT_MAIN:
                toolbar.setTitle("");
                title.setText(R.string.main_home);
                if (indexFragment == null){
                    indexFragment = indexFragment.getInstance();
                    fragmentTransaction.add(R.id.container,indexFragment,IndexFragment.class.getName());
                }else {
                    fragmentTransaction.show(indexFragment);
                }
                break;
            case FRAGMENT_CRATIVE:
                toolbar.setTitle("");
                title.setText(R.string.creative_design);
                if (hardwareActivity == null){
                    hardwareActivity = hardwareActivity.getInstance();
                    fragmentTransaction.add(R.id.container,hardwareActivity,HardwareActivity.class.getName());
                }else {
                    fragmentTransaction.show(hardwareActivity);
                }
                break;
            case FRAGMENT_ENV:
                toolbar.setTitle("");
                title.setText(R.string.env);
                if(envFragement==null){
                    envFragement=envFragement.getInstance();
                    fragmentTransaction.add(R.id.container,envFragement,EnvFragment.class.getName());
                }else {
                    fragmentTransaction.show(envFragement);
                }
                break;
        }
        fragmentTransaction.commit();


    }
    private void hideFragment(FragmentTransaction ft) {
        // 如果不为空，就先隐藏起来
        if (indexFragment != null) {
            ft.hide(indexFragment);
        }
        if (hardwareActivity != null) {
            ft.hide(hardwareActivity);
        }
        if(envFragement!=null){
            ft.hide(envFragement);
        }
    }

    private void initData(){
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();
        drawerLayout.addDrawerListener(toggle);
        bottom_navigation.setOnNavigationItemSelectedListener(item -> {
            switch (item.getItemId()){
                case R.id.item1:
                    showFragment(FRAGMENT_MAIN);
                    break;
                case R.id.item2:
                    showFragment(FRAGMENT_CRATIVE);
                    break;
                case R.id.item3:
                    showFragment(FRAGMENT_ENV);
                    break;
            }
            return true;
        });

    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.info:
                if(ApiConfig.UserName!=null){
                    Toast.makeText(this, "欢迎您"+ApiConfig.UserName, Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(this, "您还未登录哦", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.shebeiId:
                if(ApiConfig.ID!=null){
                    Toast.makeText(this, "当前设备号"+ApiConfig.ID, Toast.LENGTH_SHORT).show();

                }else {
                    Toast.makeText(this, "当前未连接设备", Toast.LENGTH_SHORT).show();

                }
            case R.id.settings:
                break;
            case R.id.about:
                startActivity(new Intent(this,TeamActivity.class));
                break;
        }
        return true;
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.circleImage){    /*点击头像跳转登录界面*/
            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            //finish();
        }
        drawerLayout.closeDrawer(GravityCompat.START);

    }
}
