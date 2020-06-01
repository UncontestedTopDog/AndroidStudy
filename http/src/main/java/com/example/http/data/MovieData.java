package com.example.http.data;

import com.google.gson.Gson;
import com.google.gson.annotations.SerializedName;

import java.util.List;

import androidx.annotation.NonNull;

public class MovieData {
    private String bImg;

    private String date;

    private boolean hasPromo;

    private int lid;

    @SerializedName("ms")
    private List<Ms> ms;

    private int newActivitiesTime;

    private Promo promo;

    private int totalComingMovie;

    private String voucherMsg;

    public void setBImg(String bImg) {
        this.bImg = bImg;
    }

    public String getBImg() {
        return this.bImg;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate() {
        return this.date;
    }

    public void setHasPromo(boolean hasPromo) {
        this.hasPromo = hasPromo;
    }

    public boolean getHasPromo() {
        return this.hasPromo;
    }

    public void setLid(int lid) {
        this.lid = lid;
    }

    public int getLid() {
        return this.lid;
    }

    public void setMs(List<Ms> ms) {
        this.ms = ms;
    }

    public List<Ms> getMs() {
        return this.ms;
    }

    public void setNewActivitiesTime(int newActivitiesTime) {
        this.newActivitiesTime = newActivitiesTime;
    }

    public int getNewActivitiesTime() {
        return this.newActivitiesTime;
    }

    public void setPromo(Promo promo) {
        this.promo = promo;
    }

    public Promo getPromo() {
        return this.promo;
    }

    public void setTotalComingMovie(int totalComingMovie) {
        this.totalComingMovie = totalComingMovie;
    }

    public int getTotalComingMovie() {
        return this.totalComingMovie;
    }

    public void setVoucherMsg(String voucherMsg) {
        this.voucherMsg = voucherMsg;
    }

    public String getVoucherMsg() {
        return this.voucherMsg;
    }

    @NonNull
    @Override
    public String toString() {
        return new Gson().toJson(this);
    }
}
