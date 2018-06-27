package com.xxmassdeveloper.mpchartexample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListActivity extends AppCompatActivity {


    private Toolbar mToolbar;
    private ListView lv_list;

    private Activity mActivity;
    private List<Balance> mList;
    private ListAdapter mListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

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
        mListAdapter =  new ListAdapter(mActivity, mList);
        lv_list.setAdapter(mListAdapter);
    }

    private void initData() {

        mList = new ArrayList<>();
        Balance balance1 = new Balance("20180626", "2966.57", "-2174.9");
        mList.add(balance1);
        Balance balance2 = new Balance("20180625", "2966.79", "-12721.5");
        mList.add(balance2);
        Balance balance3 = new Balance("20180624", "2968.06", "-16263.6");
        mList.add(balance3);
        Balance balance4 = new Balance("20180623", "2969.69", "-17195.1");
        mList.add(balance4);
        Balance balance5 = new Balance("20180622", "2971.41", "9224.3");
        mList.add(balance5);
        Balance balance6 = new Balance("20180621", "2970.49", "201.0");
        mList.add(balance6);
        Balance balance7 = new Balance("20180620", "2970.47", "-15851.4");
        mList.add(balance7);
        Balance balance8 = new Balance("20180619", "2972.05", "21841.7");
        mList.add(balance8);
        Balance balance9 = new Balance("20180618", "2969.87", "-1853.8");
        mList.add(balance9);
        Balance balance10 = new Balance("20180617", "2970.05", "-10000.7");
        mList.add(balance10);
        Balance balance11 = new Balance("20180616", "2971.05", "-11155.0");
        mList.add(balance11);
        Balance balance12 = new Balance("20180615", "2972.17", "10105.2");
        mList.add(balance12);
        Balance balance13 = new Balance("20180614", "2971.16", "16257.8");
        mList.add(balance13);
        Balance balance14 = new Balance("20180613", "2969.53", "-5658.1");
        mList.add(balance14);
        Balance balance15 = new Balance("20180612", "2970.10", "-12969.2");
        mList.add(balance15);
        Balance balance16 = new Balance("20180611", "2971.40", "-9069.5");
        mList.add(balance16);
        Balance balance17 = new Balance("20180610", "2972.30", "10168.5");
        mList.add(balance17);
        Balance balance18 = new Balance("20180609", "2974.95", "-13527.1");
        mList.add(balance18);
        Balance balance19 = new Balance("20180608", "2976.30", "10168.5");
        mList.add(balance19);
        Balance balance20 = new Balance("20180607", "2975.29", "-12177.0");
        mList.add(balance20);
        Balance balance21 = new Balance("20180606", "2976.50", "-11506.1");
        mList.add(balance21);
        Balance balance22 = new Balance("20180605", "2977.66", "-18318.8");
        mList.add(balance22);
        Balance balance23 = new Balance("20180604", "2979.49", "-22144.6");
        mList.add(balance23);
        Balance balance24 = new Balance("20180603", "2981.70", "-20742.1");
        mList.add(balance24);
        Balance balance25 = new Balance("20180602", "2983.78", "-15711.5");
        mList.add(balance25);
        Balance balance26 = new Balance("20180601", "2985.35", "5661.3");
        mList.add(balance26);
        Balance balance27 = new Balance("20180531", "2984.78", "3372.8");
        mList.add(balance27);
        Balance balance28 = new Balance("20180530", "2984.44", "-18501.6");
        mList.add(balance28);
        Balance balance29 = new Balance("20180529", "2986.29", "-17570.1");
        mList.add(balance29);
        Balance balance30 = new Balance("20180528", "2988.05", "-20645.1");
        mList.add(balance30);
    }
}
