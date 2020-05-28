package com.example.http.data;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.annotation.NonNull;

public class MovieData {
    /**
     * {"bImg":"http://img5.mtime.cn/mg/2018/09/04/124630.14485487.jpg",
     *     "date":"",
     *     "hasPromo":false,
     *     "lid":0,
     *     "ms":[],
     *     "newActivitiesTime":0,
     *     "promo":{},
     *     "totalComingMovie":0,
     *     "voucherMsg":""}
     */

    @SerializedName("bImg")
    public String bImg;
    @SerializedName("date")
    public String date;
    @SerializedName("hasPromo")
    public boolean hasPromo;
    @SerializedName("lid")
    public int lid;
    @SerializedName("ms")
    public List<String> ms;
    @SerializedName("newActivitiesTime")
    public int newActivitiesTime;
    @SerializedName("promo")
    public Object promo;
    @SerializedName("totalComingMovie")
    public int totalComingMovie;
    @SerializedName("voucherMsg")
    public String voucherMsg;

    @NonNull
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
