package com.example.bs535.yakk.content;

import org.litepal.crud.DataSupport;

/**
 * Created by BS535 on 2017/11/7.
 */


public class Yak extends DataSupport {
    private String id;//牦牛id
    private int yakCode;//牦牛代号
    private int userCode;//所属的用户

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getUserCode() {
        return userCode;
    }

    public void setUserCode(int userCode) {
        this.userCode = userCode;
    }

    public int getYakCode() {
        return yakCode;
    }

    public void setYakCode(int yakCode) {
        this.yakCode = yakCode;
    }
}
