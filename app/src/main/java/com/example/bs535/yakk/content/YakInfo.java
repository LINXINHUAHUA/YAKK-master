package com.example.bs535.yakk.content;

import org.litepal.crud.DataSupport;

/**
 * Created by BS535 on 2017/11/7.
 */

public class YakInfo extends DataSupport {
    private String id;//牦牛id
    private String sex;//牦牛性别
    private int weight;//牦牛重量
    private int length;//牦牛体长
    private String type;//牦牛类型
    private String time;//注册时间
    private int yakCode;//所属的牦牛code

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getYakCode() {
        return yakCode;
    }

    public void setYakCode(int yakCode) {
        this.yakCode = yakCode;
    }
}
