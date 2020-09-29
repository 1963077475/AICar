package com.example.aicarapplication.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.EventLogTags;

import com.example.aicarapplication.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.LimitLine;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.XAxisValueFormatter;
import com.github.mikephil.charting.formatter.YAxisValueFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;

import java.util.ArrayList;

public class HistoryActivity extends AppCompatActivity {
    private LineChart lineChart;
    private XAxis xAxis;
    private YAxis leftYAxis;
    private YAxis rightYaxis;
    private Legend legend;
    private LimitLine limitLine;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        initView();
        initLineChart();
        initLineChartData();
        setChartFillDrawable();
    }
    private void initView(){
        lineChart=findViewById(R.id.lineChart);
        lineChart.setDescription("每周分数");


    }
    private void initLineChartData(){
        ArrayList<String> names=new ArrayList<>();
        names.add("周一");
        names.add("周二");
        names.add("周三");
        names.add("周四");
        names.add("周五");
        names.add("周六");
        names.add("周日");
        ArrayList<Entry> entries=new ArrayList<>();
        entries.add(new Entry((float) (Math.random()*(90-100)+100),0));
        entries.add(new Entry((float) (Math.random()*(90-100)+100),1));
        entries.add(new Entry((float) (Math.random()*(90-100)+100),2));
        entries.add(new Entry((float) (Math.random()*(90-100)+100),3));
        entries.add(new Entry((float) (Math.random()*(90-100)+100),4));
        entries.add(new Entry((float) (Math.random()*(90-100)+100),5));
        entries.add(new Entry((float) (Math.random()*(90-100)+100),6));
        LineDataSet lineDataSet=new LineDataSet(entries,"环境评分");
        initLineDataSet(lineDataSet);
        LineData lineData=new LineData(names,lineDataSet);
        lineChart.setData(lineData);


        leftYAxis.setLabelCount(8,true);
    }


    public void setChartFillDrawable() {
        if (lineChart.getData() != null && lineChart.getData().getDataSetCount() > 0) {
            LineDataSet lineDataSet = (LineDataSet) lineChart.getData().getDataSetByIndex(0);
            //避免在 initLineDataSet()方法中 设置了 lineDataSet.setDrawFilled(false); 而无法实现效果
            lineDataSet.setDrawFilled(true);

            lineChart.invalidate();
        }
    }
    private void initLineChart(){
        //图标设置
        //是否展示网格
        lineChart.setDrawGridBackground(true);
        //显示边界
        lineChart.setDrawBorders(true);
        //设置可以拖动
        lineChart.setDragEnabled(true);
        //关闭触摸事件
        lineChart.setTouchEnabled(false);
        //设置动画
        lineChart.animateX(2500);
        lineChart.animateY(1500);
        /**
         * XY轴设置
         */
        xAxis=lineChart.getXAxis();
        leftYAxis=lineChart.getAxisLeft();
        rightYaxis=lineChart.getAxisRight();
        //设置x轴显示在底部
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);

        //保证Y从0开始
        leftYAxis.setAxisMinValue(0f);
        rightYaxis.setAxisMinValue(0f);
        //图例
        legend=lineChart.getLegend();
        legend.setForm(Legend.LegendForm.LINE);
        legend.setTextSize(12f);
        //显示位置左下方
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_RIGHT);
        legend.setTextSize(15f);

        lineChart.setBackgroundColor(Color.WHITE);
//是否显示边界
        lineChart.setDrawBorders(false);
        //但还是显示了网格线，而且不是我们想要的 虚线 。其实那是 X Y轴自己的网格线，禁掉即可
        xAxis.setDrawGridLines(false);
        rightYaxis.setDrawGridLines(false);
        leftYAxis.setDrawGridLines(true);
        //设置X Y轴网格线为虚线（实体线长度、间隔距离、偏移量：通常使用 0）
        leftYAxis.enableGridDashedLine(10f, 10f, 0f);
        //目标效果图没有右侧Y轴，所以去掉右侧Y轴
        rightYaxis.setEnabled(false);
    }
    private void initLineDataSet(LineDataSet lineDataSet){
        lineDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        lineDataSet.setLineWidth(1f);
        //lineDataSet.setCircleRadius(3f);
        //设置曲线值的圆点是实心还是空心
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setValueTextSize(10f);
        //设置折线图填充
        lineDataSet.setDrawFilled(true);
       // lineDataSet.setFormLineWidth(1f);
        //lineDataSet.setFormSize(15.f);



    }
}