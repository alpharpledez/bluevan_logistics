package com.tencent.wxcloudrun.model.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.config.L;

import java.io.Serializable;

public class Cargo extends BaseObject implements Serializable{

    private String name;
    private int count;
    private String cargoType;
    private String packageType;
    private double volume;
    private double weight;
    private String note;
    private int subcount;

    public static Cargo objectify(String str) {
        try {
            Cargo cargo = new Cargo();
            JSONObject obj = JSON.parseObject(str);
            cargo.name = obj.getString("name");
            cargo.count = obj.getInteger("count");
          if(obj.containsKey("subcount"))  cargo.subcount = obj.getInteger("subcount");
          else cargo.subcount = 0;
            cargo.cargoType = obj.getString("cargoType");
            cargo.packageType = obj.getString("packageType");
            cargo.volume = obj.getDouble("volume");
            cargo.weight = obj.getDouble("weight");
            cargo.note = obj.getString("note");

            return cargo;

        } catch (Exception e) {
            L.error(e.toString());
            return null;
        }
    }

    @Override
    public String stringify() {
        try {
            JSONObject obj = this.toJSON();
            return obj.toString();
        } catch (Exception e) {
            L.error(e.toString());
            return null;
        }
    }

    @Override
    public JSONObject toJSON() {
        JSONObject obj = new JSONObject();
        obj.put("name", name);
        obj.put("count", count);
        obj.put("subcount", subcount);
        obj.put("cargoType", cargoType);
        obj.put("packageType", packageType);
        obj.put("volume", volume);
        obj.put("weight", weight);
        obj.put("note", note);
        return obj;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getCargoType() {
        return cargoType;
    }

    public void setCargoType(String cargoType) {
        this.cargoType = cargoType;
    }

    public String getPackageType() {
        return packageType;
    }

    public void setPackageType(String packageType) {
        this.packageType = packageType;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public int getSubcount() {
        return subcount;
    }

    public void setSubcount(int subcount) {
        this.subcount = subcount;
    }
}
