package com.example.aicarapplication.Activity;


import android.app.ProgressDialog;

import android.content.Intent;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.aicarapplication.R;
import com.example.aicarapplication.data.ApiConfig;
import com.github.mikephil.charting.charts.PieChart;

import com.github.mikephil.charting.components.Legend;

import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;

import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;


public class  EnvFragment extends Fragment {
    private static EnvFragment instance = null;
    private PieChart pieChart;
    private Button button,history;
    static EnvFragment getInstance() {
        if (instance == null) {
            instance = new EnvFragment();
        }
        return instance;
    }
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_env, container, false);
        pieChart=view.findViewById(R.id.env_piechart);
        button=view.findViewById(R.id.start_button);
        history=view.findViewById(R.id.history);
        // todo
        Legend legend = pieChart.getLegend();
        legend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        //legend.setDirection(Legend.LegendDirection.LEFT_TO_RIGHT);
        //legend.setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
        pieChart.setCenterTextSize(15);
        pieChart.setNoDataText("正在等待数据刷新");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(ApiConfig.ID==null){
                    Toast.makeText(getContext(), "请先连接设备", Toast.LENGTH_SHORT).show();
                }else {
                    ProgressDialog waitDialog=new ProgressDialog(getContext());
                    waitDialog.setIcon(R.mipmap.ic_launcher_round);
                    waitDialog.setTitle("正在获取数据");
                    waitDialog.setMessage("请稍等");
                    waitDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
                    waitDialog.setCancelable(true);
                    waitDialog.show();
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Thread.sleep(2000);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                            waitDialog.dismiss();
                        }

                    }).start();

                    pieChart.setCenterText("病房环境信息");
                    initChart(pieChart,start());

                }


            }


        });
        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(),HistoryActivity.class));
            }
        });

        return view;
    }
    private PieData start() {
        ArrayList<String> names=new ArrayList<>();
        names.add("空气质量");
        names.add("通风情况");
        names.add("湿度");
        names.add("室内温度");

        ArrayList<Entry> values=new ArrayList<>();
        values.add(new Entry((float)Math.random(),0));
        values.add(new Entry((float)Math.random(),1));
        values.add(new Entry((float)Math.random(),2));
        values.add(new Entry((float)Math.random(),3));
        ArrayList<Integer> colors=new ArrayList<>();
        PieDataSet dataSet=new PieDataSet(values,"环境监测");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        PieData pieData=new PieData(names,dataSet);
        return pieData;
    }
    private void initChart(PieChart pieChart,PieData pieData){
        pieChart.animateXY(3000,3000);
        pieChart.setData(pieData);
        pieChart.setDescription(null);
        pieChart.invalidate();
    }

}
