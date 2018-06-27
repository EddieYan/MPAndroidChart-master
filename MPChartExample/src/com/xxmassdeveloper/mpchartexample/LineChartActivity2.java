
package com.xxmassdeveloper.mpchartexample;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.Legend.LegendForm;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.components.YAxis.AxisDependency;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

public class LineChartActivity2 extends AppCompatActivity implements OnChartValueSelectedListener, Toolbar.OnMenuItemClickListener {


    private Toolbar mToolbar;
    private LineChart mChart;

    private Activity mActivity;
    private Typeface mTfLight;

    String[] scoreRange = {"19", "18", "17", "16", "15", "14", "13", "12", "11", "10", "09", "08", "07", "06", "05", "04", "03", "02",
            "01", "31", "30", "29", "28", "27", "26", "25", "24", "23", "22", "21"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linechart);

        mActivity = this;
        mChart = findViewById(R.id.chart1);
        mChart.setOnChartValueSelectedListener(this);

        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setOnMenuItemClickListener(this);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });

        mTfLight = Typeface.createFromAsset(getAssets(), "OpenSans-Light.ttf");

        // no description text
        mChart.getDescription().setEnabled(false);

        // enable touch gestures
        mChart.setTouchEnabled(true);

        mChart.setDragDecelerationFrictionCoef(0.9f);

        // enable scaling and dragging
        mChart.setDragEnabled(true);
        mChart.setScaleEnabled(true);
        mChart.setDrawGridBackground(false);
        mChart.setHighlightPerDragEnabled(true);

        // if disabled, scaling can be done on x- and y-axis separately
        mChart.setPinchZoom(true);

        // set an alternative background color
        mChart.setBackgroundColor(Color.WHITE);

        // add data
        setData(30, 30);

        mChart.animateX(2500);

        // get the legend (only possible after setting data)
        Legend l = mChart.getLegend();

        // modify the legend ...
        l.setForm(LegendForm.LINE);
        l.setTypeface(mTfLight);
        l.setTextSize(11f);
        l.setTextColor(Color.BLACK);
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.BOTTOM);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.LEFT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);

        XAxis xAxis = mChart.getXAxis();
        xAxis.setTypeface(mTfLight);
        xAxis.setTextSize(8f);
        xAxis.setTextColor(Color.BLACK);
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);//是否显示坐标轴那条轴
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return scoreRange[(int) value % scoreRange.length];
            }
        });

        xAxis.setDrawLabels(true);    //是不是显示轴上的刻度
        mChart.getAxisLeft().setDrawGridLines(false);
        xAxis.setGranularity(0f);//设置最小间隔，防止当放大时，出现重复标签
        xAxis.setLabelCount(scoreRange.length);//设置X轴的显示个数

        YAxis leftAxis = mChart.getAxisLeft();
        leftAxis.setTypeface(mTfLight);
        leftAxis.setTextColor(Color.BLACK);
        leftAxis.setDrawGridLines(true);
        leftAxis.setGranularityEnabled(true);

        YAxis rightAxis = mChart.getAxisRight();
        rightAxis.setTypeface(mTfLight);
        rightAxis.setTextColor(Color.TRANSPARENT);
        rightAxis.setAxisMaximum(900);
        rightAxis.setAxisMinimum(-200);
        rightAxis.setDrawGridLines(false);
        rightAxis.setDrawZeroLine(false);
        rightAxis.setGranularityEnabled(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.actionToggleVerticalScreen:
                if(getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                    //切换竖屏
                    mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                }else{
                    //切换横屏
                    mActivity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
                }
                break;
            case R.id.actionToggleForm:
                Intent intent = new Intent(mActivity, ListActivity.class);
                startActivity(intent);
                break;
        }
        return false;
    }

    private void setData(int count, float range) {

        ArrayList<Entry> yVals1 = new ArrayList<>();

        for (int i = 0; i < count; i++) {

            if(i == 0){
                yVals1.add(new Entry(i, -15851.4f));
            }else if(i == 1){
                yVals1.add(new Entry(i, 21841.7f));
            }else if(i == 2){
                yVals1.add(new Entry(i, -1853.8f));
            }else if(i == 3){
                yVals1.add(new Entry(i, -10000.7f));
            }else if(i == 4){
                yVals1.add(new Entry(i, -11155.0f));
            }else if(i == 5){
                yVals1.add(new Entry(i, 10105.2f));
            }else if(i == 6){
                yVals1.add(new Entry(i, -5658.1f));
            }else if(i == 7){
                yVals1.add(new Entry(i, -12969.4f));
            }else if(i == 8){
                yVals1.add(new Entry(i, -9069.5f));
            }else if(i == 9){
                yVals1.add(new Entry(i, -26488.1f));
            }else if(i == 10){
                yVals1.add(new Entry(i, -13527.1f));
            }else if(i == 11){
                yVals1.add(new Entry(i, 10168.5f));
            }else if(i == 12){
                yVals1.add(new Entry(i, -12177.0f));
            }else if(i == 13){
                yVals1.add(new Entry(i, -11506.1f));
            }else if(i == 14){
                yVals1.add(new Entry(i, -18318.8f));
            }else if(i == 15){
                yVals1.add(new Entry(i, -22144.6f));
            }else if(i == 16){
                yVals1.add(new Entry(i, -20742.1f));
            }else if(i == 17){
                yVals1.add(new Entry(i, -15711.5f));
            }else if(i == 18){
                yVals1.add(new Entry(i, 5661.3f));
            }else if(i == 19){
                yVals1.add(new Entry(i, 3372.8f));
            }else if(i == 20){
                yVals1.add(new Entry(i, -18501.6f));
            }else if(i == 21){
                yVals1.add(new Entry(i, -17570.1f));
            }else if(i == 22){
                yVals1.add(new Entry(i, -20645.1f));
            }else if(i == 23){
                yVals1.add(new Entry(i, -21612.8f));
            }else if(i == 24){
                yVals1.add(new Entry(i, 23392.1f));
            }else if(i == 25){
                yVals1.add(new Entry(i, 23392.1f));
            }else if(i == 26){
                yVals1.add(new Entry(i, 1938.2f));
            }else if(i == 27){
                yVals1.add(new Entry(i, 4478.2f));
            }else if(i == 28){
                yVals1.add(new Entry(i, -12909.9f));
            }else if(i == 29){
                yVals1.add(new Entry(i, -10312.5f));
            }
        }

        LineDataSet set1;

        if (mChart.getData() != null && mChart.getData().getDataSetCount() > 0) {
            set1 = (LineDataSet) mChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            // create a dataset and give it a type
            set1 = new LineDataSet(yVals1, "余额增量30日明细-日增");

            set1.setAxisDependency(AxisDependency.LEFT);
            set1.setColor(ColorTemplate.getHoloBlue());
            set1.setCircleColor(ColorTemplate.getHoloBlue());
            set1.setLineWidth(2f);
            set1.setCircleRadius(5f);
            set1.setFillAlpha(65);
            set1.setFillColor(ColorTemplate.getHoloBlue());
            set1.setHighLightColor(Color.rgb(244, 117, 117));
            set1.setDrawCircleHole(false);
            set1.setMode(set1.getMode() == LineDataSet.Mode.CUBIC_BEZIER
                    ? LineDataSet.Mode.LINEAR
                    : LineDataSet.Mode.CUBIC_BEZIER);

            LineData data = new LineData(set1);
            data.setValueTextColor(Color.BLACK);
            data.setValueTextSize(9f);

            // set data
            mChart.setData(data);
        }
    }

    @Override
    public void onValueSelected(Entry e, Highlight h) {
        Log.i("Entry selected", e.toString());

        mChart.centerViewToAnimated(e.getX(), e.getY(), mChart.getData().getDataSetByIndex(h.getDataSetIndex()).getAxisDependency(), 500);
    }

    @Override
    public void onNothingSelected() {
        Log.i("Nothing selected", "Nothing selected.");
    }

}
