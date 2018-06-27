package com.xxmassdeveloper.mpchartexample;

/**
 * @author 闫鹏飞
 * create at 2017-11-15 0015
 * description: 查询邮储网点信息
 */
public class PieBalance {


    private String region;
    private String balance;
    private String fixed_live_ratio;

    public PieBalance() {
    }

    public PieBalance(String region, String balance, String fixed_live_ratio) {
        this.region = region;
        this.balance = balance;
        this.fixed_live_ratio = fixed_live_ratio;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getBalance() {
        return balance;
    }

    public void setBalance(String balance) {
        this.balance = balance;
    }

    public String getFixed_live_ratio() {
        return fixed_live_ratio;
    }

    public void setFixed_live_ratio(String fixed_live_ratio) {
        this.fixed_live_ratio = fixed_live_ratio;
    }
}
