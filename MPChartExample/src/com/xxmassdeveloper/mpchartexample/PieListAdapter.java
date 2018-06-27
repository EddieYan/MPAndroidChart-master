package com.xxmassdeveloper.mpchartexample;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * @author 闫鹏飞
 * create at 2017-11-15 0015
 * description: 查询邮储网点信息
 */
public class PieListAdapter extends BaseAdapter {


    private Activity mActivity;
    private List<PieBalance> mList;


    public PieListAdapter(Activity activity, List<PieBalance> list) {
        this.mActivity = activity;
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public PieBalance getItem(int position) {
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
            convertView = View.inflate(mActivity, R.layout.item_pie_list, null);
            holder = new ViewHolder();
            holder.tv_index = convertView.findViewById(R.id.tv_index);
            holder.tv_region = convertView.findViewById(R.id.tv_region);
            holder.tv_balance = convertView.findViewById(R.id.tv_balance);
            holder.tv_fixed_live_ratio = convertView.findViewById(R.id.tv_fixed_live_ratio);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_index.setText(String.valueOf(position));
        holder.tv_region.setText(getItem(position).getRegion());
        holder.tv_balance.setText(getItem(position).getBalance());
        holder.tv_fixed_live_ratio.setText(getItem(position).getFixed_live_ratio());
        if(position == 0){
            holder.tv_index.setText("#");
            holder.tv_region.setTextColor(Color.BLACK);
        }
        return convertView;
    }

    /**
     * @author 闫鹏飞
     * @time 2018-3-15 0015  10:43
     * @describe 控件
     */
    private static class ViewHolder {

        TextView tv_index;
        TextView tv_region;
        TextView tv_balance;
        TextView tv_fixed_live_ratio;
    }
}
