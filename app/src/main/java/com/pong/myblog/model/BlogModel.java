package com.pong.myblog.model;

/**
 * Created by USER on 10/1/2560.
 */

public class BlogModel {
    String title;
    String date;
    String content;

    public BlogModel() {
    }

    public BlogModel(String title, String date, String content) {
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
