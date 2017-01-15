package com.pong.myblog.model;

import android.provider.BaseColumns;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by USER on 10/1/2560.
 */

public class BlogModel {

    public static class BlogColumns implements BaseColumns {
        public static final String TABLE_NAME = "blog";
        public static final String COLUMN_NAME_TITLE = "title";
        public static final String COLUMN_NAME_DATE = "date";
        public static final String COLUMN_NAME_CONTENT = "content";
    }

    int id;
    String title;
    String date;
    String content;

    public BlogModel() {
    }

    public BlogModel(int id,String title, String date, String content) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public JSONObject toJson(){
        try {
            JSONObject obj = new JSONObject();
            obj.put("title",title);
            obj.put("date",date);
            obj.put("content",content);
            return obj;
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}
