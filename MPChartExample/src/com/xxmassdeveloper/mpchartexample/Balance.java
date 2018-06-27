package com.xxmassdeveloper.mpchartexample;

/**
 * @author 闫鹏飞
 * create at 2017-11-15 0015
 * description: 查询邮储网点信息
 */
public class Balance {


    private String data;
    private String remainder;
    private String dailyIncrease;

    public Balance() {
    }

    public Balance(String data, String remainder, String dailyIncrease) {
        this.data = data;
        this.remainder = remainder;
        this.dailyIncrease = dailyIncrease;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getRemainder() {
        return remainder;
    }

    public void setRemainder(String remainder) {
        this.remainder = remainder;
    }

    public String getDailyIncrease() {
        return dailyIncrease;
    }

    public void setDailyIncrease(String dailyIncrease) {
        this.dailyIncrease = dailyIncrease;
    }
}
