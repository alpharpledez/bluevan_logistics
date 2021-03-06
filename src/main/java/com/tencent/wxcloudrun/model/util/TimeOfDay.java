package com.tencent.wxcloudrun.model.util;

import com.alibaba.fastjson.JSONObject;

import java.io.Serializable;
import java.sql.Time;
import java.util.Arrays;
import java.util.List;

public class TimeOfDay extends BaseObject implements Serializable {
    private Integer hh;
    private Integer mm;

    public TimeOfDay(int hh, int mm) {
        this.hh = (hh >= 0 && hh < 24) ? hh : 0;
        this.mm = (mm >= 0 && mm < 60) ? mm : 0;
    }

    public void setTime(int hh, int mm) {
        this.hh = (hh >= 0 && hh < 24) ? hh : 0;
        this.mm = (mm >= 0 && mm < 60) ? mm : 0;
    }

    public Integer getHour() {
        return hh;
    }

    public Integer getMinute() {
        return mm;
    }

    @Override
    public String toString() {
        return pad(this.hh.toString()) + ":" + pad(this.mm.toString());
    }

    private String pad(String str) {
        if (str.length() < 2) {
            return "0" + str;
        } else return str;
    }

    @Override
    public String stringify() {
        return this.toString();
    }

    @Override
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("hour",hh);
        obj.put("minute",getMinute());
        return obj;
    }

    public static TimeOfDay objectify(String str) {
        try {
            if (str == null || str.length() != 5)
                return null;
            List<String> strs = Arrays.asList(str.split(":"));
            if (strs.size() != 2)
                return null;
            return new TimeOfDay(Integer.parseInt(strs.get(0)), Integer.parseInt(strs.get(1)));
        } catch (Exception e) {
            return null;
        }
    }
}
