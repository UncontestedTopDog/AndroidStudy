package com.example.http.data;

import com.google.gson.annotations.SerializedName;

public class Versions {
    @SerializedName("enum")
    private int em;

    private String version;

    public void setEnum(int em) {
        this.em = em;
    }

    public int getEnum() {
        return this.em;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getVersion() {
        return this.version;
    }
}
