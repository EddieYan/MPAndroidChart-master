package com.xxmassdeveloper.mpchartexample;

import android.app.Activity;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * @author 闫鹏飞
 * create at 2017-11-15 0015
 * description: 查询邮储网点信息
 */
public class ListAdapter extends BaseAdapter {


    private Activity mActivity;
    private List<Balance> mList;


    public ListAdapter(Activity activity, List<Balance> list) {
        this.mActivity = activity;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Balance getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = View.inflate(mActivity, R.layout.item_list, null);
            holder = new ViewHolder();
            holder.ll_background = convertView.findViewById(R.id.ll_background);
            holder.tv_data = convertView.findViewById(R.id.tv_data);
            holder.tv_remainder = convertView.findViewById(R.id.tv_remainder);
            holder.tv_daily_increase = convertView.findViewById(R.id.tv_daily_increase);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_data.setText(getItem(position).getData());
        holder.tv_remainder.setText(getItem(position).getRemainder());
        holder.tv_daily_increase.setText(getItem(position).getDailyIncrease());
        if(Double.valueOf(getItem(position).getDailyIncrease())>=0){
            holder.tv_daily_increase.setTextColor(Color.BLUE);
        }else {
            holder.tv_daily_increase.setTextColor(Color.RED);
        }
        if(position%2==1){
            holder.ll_background.setBackgroundColor(ContextCompat.getColor(mActivity, R.color.color_d9edf7));
        }else {
            holder.ll_background.setBackgroundColor(Color.WHITE);
        }
        return convertView;
    }

    /**
     * @author 闫鹏飞
     * @time 2018-3-15 0015  10:43
     * @describe 控件
     */
    private static class ViewHolder {

        LinearLayout ll_background;
        TextView tv_data;
        TextView tv_remainder;
        TextView tv_daily_increase;
    }
}
