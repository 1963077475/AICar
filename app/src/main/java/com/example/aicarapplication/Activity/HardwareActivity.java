package com.example.aicarapplication.Activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;

import com.example.aicarapplication.R;
import com.example.aicarapplication.data.ApiConfig;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class HardwareActivity extends Fragment implements View.OnClickListener {
    private static HardwareActivity instance;
    private Button connectionHare,connectionVideo,stopVideo;
    private VideoView videoView;
    private Map<Integer,Integer> dataObjects=new HashMap<Integer, Integer>();
    private PieChart pieChart;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }
    public static HardwareActivity getInstance(){
        if(instance==null){
            instance=new HardwareActivity();
        }
        return instance;
    }
    public HardwareActivity() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hareware, container, false);
        initView(view);
        return view;

    }
    private void initView(View view){
        connectionHare = view.findViewById(R.id.connectionButton);
        connectionHare.setOnClickListener(this);
        videoView=view.findViewById(R.id.video);
        connectionVideo=view.findViewById(R.id.connectionVideo);
        connectionVideo.setOnClickListener(this);
        stopVideo=view.findViewById(R.id.stopVideo);
        stopVideo.setOnClickListener(this);


    }

    @Override
    public void onStart() {
        super.onStart();
        videoView.start();
    }

    @Override
    public void onStop() {
        super.onStop();
        videoView.pause();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.connectionButton:
                if(ApiConfig.ID==null){
                    final EditText editText=new EditText(getContext());
                    AlertDialog.Builder builder=new AlertDialog.Builder(getContext());
                    builder.setIcon(R.mipmap.ic_launcher_round);
                    builder.setTitle("请输入设备号").setView(editText);
                    builder.setPositiveButton("确定", (dialog, which) -> {
                        Log.d("TAG", "onClick: "+editText.getText().toString());
                        if(editText.getText().toString().equals("1963077")){
                            ApiConfig.ID=editText.getText().toString();
                            Toast.makeText(getContext(), "连接设备成功!", Toast.LENGTH_SHORT).show();
                            getActivity().runOnUiThread(() -> {
                                connectionHare.setText("点击解除设备(当前设备ID+"+ApiConfig.ID+")");

                            });
                        }else {
                            Toast.makeText(getContext(), "设备号错误，请重试!", Toast.LENGTH_SHORT).show();
                        }


                    });
                    builder.show();
                }else {
                    ApiConfig.ID=null;
                    Toast.makeText(getContext(),"解除成功",Toast.LENGTH_SHORT).show();
                    getActivity().runOnUiThread(()->{
                        connectionHare.setText("点击连接设备");
                    });
                }

            case R.id.connectionVideo:
                if(ApiConfig.ID==null)
                    Toast.makeText(getContext(), "请先连接设备", Toast.LENGTH_SHORT).show();
                else {
                    MediaController mediaController=new MediaController(getContext());
                    /**
                     * "android.resource://" +
                     *                         getContext().getPackageName() + "/raw/" +
                     *                         R.raw.car1
                     */
                    String uri="android.resource://"+getContext().getPackageName()+"/raw/"+R.raw.video;
                    videoView.setVideoPath(uri);
                    videoView.requestFocus();
                    videoView.start();

                }
                break;
            case R.id.stopVideo:
                videoView.pause();
                break;
        }


    }
}
