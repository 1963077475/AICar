package com.example.aicarapplication.Activity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.aicarapplication.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class HardwareActivity extends Fragment {
    private Map<Integer,Integer> dataObjects=new HashMap<Integer, Integer>();
    private LineChart lineChart;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataObjects.put(12,5);
        dataObjects.put(16,4);
        dataObjects.put(78,8);
        dataObjects.put(65,45);
        dataObjects.put(12,74);
    }

    public HardwareActivity() {

    }

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.hareware, container, false);
        lineChart=view.findViewById(R.id.chart);
        List<Entry> dataList=new ArrayList();
        Set<Integer> integers = dataObjects.keySet();
        dataList.add(new Entry(5, 50));
        dataList.add(new Entry(10, 66));
        dataList.add(new Entry(15, 120));
        dataList.add(new Entry(20, 30));
        dataList.add(new Entry(35, 10));
        dataList.add(new Entry(40, 110));
        dataList.add(new Entry(45, 30));
        dataList.add(new Entry(50, 160));
        dataList.add(new Entry(100, 30));
        LineDataSet lineDataSet=new LineDataSet(dataList,"Label1");
        lineDataSet.setColor(R.color.color_303f9f);
        LineData lineData=new LineData(lineDataSet);
        lineChart.setData(lineData);
        //lineChart.highlightValues(new Highlight[]{new Highlight(1.2f,3,2)});
        lineChart.invalidate();
        return view;
    }
}
