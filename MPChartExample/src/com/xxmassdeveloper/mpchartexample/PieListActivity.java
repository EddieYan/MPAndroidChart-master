package com.xxmassdeveloper.mpchartexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class PieListActivity extends AppCompatActivity {

    private Toolbar mToolbar;
    private ListView lv_list;

    private Activity mActivity;
    private List<PieBalance> mList;
    private PieListAdapter mListAdapter;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_list);

        mActivity = this;
        mToolbar = findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                finish();
            }
        });

        lv_list = findViewById(R.id.lv_list);

        initData();
        mListAdapter =  new PieListAdapter(mActivity, mList);
        lv_list.setAdapter(mListAdapter);
    }

    private void initData() {

        mList = new ArrayList<>();
        PieBalance balance1 = new PieBalance("全省合计", "2966.57", "26.48");
        mList.add(balance1);
        PieBalance balance2 = new PieBalance("蚌埠地区", "105.88", "42.1");
        mList.add(balance2);
        PieBalance balance3 = new PieBalance("宿州地区", "286.30", "39.7");
        mList.add(balance3);
        PieBalance balance4 = new PieBalance("亳州地区", "213.13", "32.2");
        mList.add(balance4);
        PieBalance balance5 = new PieBalance("阜阳地区", "425.33", "28.8");
        mList.add(balance5);
        PieBalance balance6 = new PieBalance("滁州地区", "137.16", "28.4");
        mList.add(balance6);
        PieBalance balance7 = new PieBalance("合肥地区", "268.85", "-26.0");
        mList.add(balance7);
        PieBalance balance8 = new PieBalance("淮南地区", "151.61", "25.6");
        mList.add(balance8);
        PieBalance balance9 = new PieBalance("宣城地区", "108.68", "25.5");
        mList.add(balance9);
        PieBalance balance10 = new PieBalance("淮北地区", "95.36", "25.4");
        mList.add(balance10);
        PieBalance balance11 = new PieBalance("芜湖地区", "183.18", "23.2");
        mList.add(balance11);
        PieBalance balance12 = new PieBalance("六安地区", "221.20", "22.3");
        mList.add(balance12);
        PieBalance balance13 = new PieBalance("马鞍山地区", "94.59", "21.9");
        mList.add(balance13);
        PieBalance balance14 = new PieBalance("安庆地区", "377.49", "19.8");
        mList.add(balance14);
        PieBalance balance15 = new PieBalance("池州地区", "104.21", "19.4");
        mList.add(balance15);
        PieBalance balance16 = new PieBalance("黄山地区", "69.21", "15.7");
        mList.add(balance16);
        PieBalance balance17 = new PieBalance("铜陵地区", "124.38", "14.8");
        mList.add(balance17);
    }
}
