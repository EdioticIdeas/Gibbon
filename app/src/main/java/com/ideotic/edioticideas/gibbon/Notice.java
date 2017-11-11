package com.ideotic.edioticideas.gibbon;

/**
 * Created by Mukul on 20-04-2017.
 */

public class Notice {

    private String title = null;
    private String body = null;
    private String date = null;
    private String time = null;

    public Notice(String titl, String bod, String dat, String tim) {

        this.title = titl;
        this.body = bod;
        this.date = dat;
        this.time = tim;
    }

    public String getTitle() {
        return title;
    }

    public String getBody() {
        return body;
    }

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }
}
