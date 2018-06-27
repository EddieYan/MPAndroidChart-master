
package com.xxmassdeveloper.mpchartexample;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Matrix;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.XAxis.XAxisPosition;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.IDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;
import com.github.mikephil.charting.utils.ViewPortHandler;
import com.xxmassdeveloper.mpchartexample.notimportant.DemoBase;

import java.util.ArrayList;

public class AnotherBarActivity extends DemoBase implements View.OnClickListener{

    private BarChart mChart;
    private String[] mCity = new String[] {
            "阜阳", "安庆", "宿州", "合肥", "六安", "亳州", "芜湖", "淮南", "滁州", "铜陵", "宣城", "蚌埠","池州","淮北","马鞍山","黄山"
    };
    private Button button_ye,button_yezl,button_image;
    private ImageView iv_chart;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_barchart);
        mChart = findViewById(R.id.chart1);
        button_ye = findViewById(R.id.button_ye);
        button_yezl = findViewById(R.id.button_yzzl);
        button_image = findViewById(R.id.button_image);
        button_ye.setOnClickListener(this);
        button_yezl.setOnClickListener(this);
        button_image.setOnClickListener(this);
        mChart.getDescription().setEnabled(false);
        // if more than 60 entries are displayed in the chart, no values will be
        mChart.setMaxVisibleValueCount(60);
        // scaling can now only be done on x- and y-axis separately
        mChart.setPinchZoom(false);
        mChart.setDrawBarShadow(false);
        mChart.setDrawGridBackground(false);
        mChart.setExtraRightOffset(5f);
        XAxis xAxis = mChart.getXAxis();
        xAxis.setPosition(XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return mCity[(int) value % mCity.length];
            }
        });
        xAxis.setDrawAxisLine(true);    //是否显示坐标轴那条轴
        xAxis.setDrawLabels(true);    //是不是显示轴上的刻度
        //xAxis.setLabelCount(mCity.length);    //强制有多少个刻度
        xAxis.setTextColor(Color.parseColor("#000000"));
        mChart.getAxisLeft().setDrawGridLines(false);
        initData();
        xAxis.setGranularity(0f);//设置最小间隔，防止当放大时，出现重复标签
        YAxis ya =mChart.getAxisLeft();
        ya.setStartAtZero(false);
        ya.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return value+"（亿）";
            }
        });
        // setting data
        // add a nice and smooth animation
       // mChart.animateY(2500);
        mChart.getLegend().setEnabled(false);
        //将条目放大 可滑动
        mChart.invalidate();
        Matrix mMatrix = new Matrix();
        mMatrix.postScale(2f, 1f); //X轴宽度放大2倍 竖直方向不变
        mChart.getViewPortHandler().refresh(mMatrix, mChart, false);
        mChart.animateY(800);
        mChart.setDoubleTapToZoomEnabled(false);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.bar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.actionToggleValues: {

                for (IDataSet set : mChart.getData().getDataSets())
                    set.setDrawValues(!set.isDrawValuesEnabled());

                mChart.invalidate();
                break;
            }
            case R.id.actionToggleHighlight: {

                if(mChart.getData() != null) {
                    mChart.getData().setHighlightEnabled(!mChart.getData().isHighlightEnabled());
                    mChart.invalidate();
                }
                break;
            }
            case R.id.actionTogglePinch: {
                if (mChart.isPinchZoomEnabled())
                    mChart.setPinchZoom(false);
                else
                    mChart.setPinchZoom(true);

                mChart.invalidate();
                break;
            }
            case R.id.actionToggleAutoScaleMinMax: {
                mChart.setAutoScaleMinMaxEnabled(!mChart.isAutoScaleMinMaxEnabled());
                mChart.notifyDataSetChanged();
                break;
            }
            case R.id.actionToggleBarBorders: {
                for (IBarDataSet set : mChart.getData().getDataSets())
                    ((BarDataSet)set).setBarBorderWidth(set.getBarBorderWidth() == 1.f ? 0.f : 1.f);

                mChart.invalidate();
                break;
            }
            case R.id.animateX: {
                mChart.animateX(3000);
                break;
            }
            case R.id.animateY: {
                mChart.animateY(3000);
                break;
            }
            case R.id.animateXY: {

                mChart.animateXY(3000, 3000);
                break;
            }
            case R.id.actionSave: {
                if (mChart.saveToGallery("title" + System.currentTimeMillis(), 50)) {
                    Toast.makeText(getApplicationContext(), "Saving SUCCESSFUL!",
                            Toast.LENGTH_SHORT).show();
                } else
                    Toast.makeText(getApplicationContext(), "Saving FAILED!", Toast.LENGTH_SHORT)
                            .show();
                break;
            }
        }
        return true;
    }
    public void initData(){
        YAxis ya =mChart.getAxisLeft();
        ya.setStartAtZero(false);
        ya.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return value+"（亿）";
            }
        });
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        Float balance[] = {426.29f,378.70f,284.42f,270.18f,221.83f,212.49f,183.75f,151.76f,136.92f,124.77f,109.52f,105.63f,104.36f,95.25f,94.46f,69.21f};
        for (int i = 0; i < 15; i++) {
            yVals1.add(new BarEntry(i, balance[i]));
        }
        BarDataSet set1;
        if (mChart.getData() != null &&
                mChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet)mChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "Data Set");
            set1.setColors(ColorTemplate.VORDIPLOM_COLORS);
            set1.setDrawValues(true);
            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);
            BarData data = new BarData(dataSets);
            data.setValueFormatter(new IValueFormatter() {
                @Override
                public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                    return value+"";
                }
            });
            mChart.setData(data);
            mChart.setFitBars(true);
        }
        mChart.invalidate();
    }
    public void initData2(){
        YAxis ya =mChart.getAxisLeft();
        ya.setStartAtZero(false);
        ya.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return value+"（万）";
            }
        });
        ArrayList<BarEntry> yVals1 = new ArrayList<BarEntry>();
        Float balance[] = {-2139.2f,-1554.5f,1520.2f,745.6f,-1415.9f,-179.0f,-1066.3f,492.2f,-104.1f,-107.2f,-110.4f,329.1f,-184.9f,225.3f,825.5f,-478.3f};
        for (int i = 0; i < 15; i++) {
            yVals1.add(new BarEntry(i, balance[i]));
        }
        BarDataSet set1;
        if (mChart.getData() != null && mChart.getData().getDataSetCount() > 0) {
            set1 = (BarDataSet)mChart.getData().getDataSetByIndex(0);
            set1.setValues(yVals1);
            mChart.getData().notifyDataChanged();
            mChart.notifyDataSetChanged();
        } else {
            set1 = new BarDataSet(yVals1, "Data Set");
            set1.setColors(ColorTemplate.VORDIPLOM_COLORS);
            set1.setDrawValues(true);
            ArrayList<IBarDataSet> dataSets = new ArrayList<IBarDataSet>();
            dataSets.add(set1);
            BarData data = new BarData(dataSets);
            data.setValueFormatter(new IValueFormatter() {
                @Override
                public String getFormattedValue(float value, Entry entry, int dataSetIndex, ViewPortHandler viewPortHandler) {
                    return value+"";
                }
            });
            mChart.setData(data);
            mChart.setFitBars(true);
        }
        mChart.invalidate();
    }

    @Override
    public void onClick(View view) {
        if(view == button_ye){
            initData();
        }else if(view == button_yezl){
            initData2();
        }else if(view == button_image){
            Intent intent = new Intent(this, ImageActivity.class);
            startActivity(intent);
        }
    }
}
