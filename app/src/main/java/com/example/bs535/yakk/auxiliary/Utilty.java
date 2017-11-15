package com.example.bs535.yakk.auxiliary;

import android.text.TextUtils;


import com.example.bs535.yakk.content.Yak;
import com.example.bs535.yakk.content.YakInfo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by baolei on 2017/10/2.
 */

public class Utilty {

    //解析学校
    public static boolean handleYakResponse(String response) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allYak = new JSONArray(response);
                for (int i = 0; i < allYak.length(); i++) {
                    JSONObject object = allYak.getJSONObject(i);
                    Yak yak = new Yak();
                    yak.setId(object.getString("name"));
                    yak.setYakCode(object.getInt("code"));
                    yak.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    //解析教学楼
    public static boolean handleYakinfoResponse(String response, int yakCode) {
        if (!TextUtils.isEmpty(response)) {
            try {
                JSONArray allYakinfo = new JSONArray(response);
                for (int i = 0; i < allYakinfo.length(); i++) {
                    JSONObject object = allYakinfo.getJSONObject(i);
                    YakInfo yak = new YakInfo();
                    yak.setLength(object.getInt("length"));
                    yak.setSex(object.getString("sex"));
                    yak.setWeight(object.getInt("weight"));
                    yak.setYakCode(yakCode);
                    yak.setTime(object.getString("time"));
                    yak.save();
                }
                return true;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return false;
    }




}
