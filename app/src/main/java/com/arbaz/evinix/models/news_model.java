package com.arbaz.evinix.models;

public class news_model {
    int image;
    String desc,header,time,country;

    public news_model(int image, String desc, String header, String time, String country) {
        this.image = image;
        this.desc = desc;
        this.header = header;
        this.time = time;
        this.country = country;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
