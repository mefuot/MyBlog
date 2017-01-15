package com.pong.myblog.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.pong.myblog.model.BlogModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 15/1/2560.
 */

public class BlogDbHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "MyBlog.db";

    private static final String SQL_CREATE_BLOG_TABLE =
            "CREATE TABLE " + BlogModel.BlogColumns.TABLE_NAME + " (" +
                    BlogModel.BlogColumns._ID + " INTEGER PRIMARY KEY," +
                    BlogModel.BlogColumns.COLUMN_NAME_TITLE + " TEXT," +
                    BlogModel.BlogColumns.COLUMN_NAME_DATE + " TEXT," +
                    BlogModel.BlogColumns.COLUMN_NAME_CONTENT + " TEXT)";

    private static final String SQL_DELETE_BLOG_TABLE =
            "DROP TABLE IF EXISTS " + BlogModel.BlogColumns.TABLE_NAME;

    public BlogDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_BLOG_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_BLOG_TABLE);
        onCreate(db);
    }

    public List<BlogModel> getAllBlog(){
        SQLiteDatabase  db = this.getWritableDatabase();
        Cursor mCursor = db.rawQuery("SELECT " + BlogModel.BlogColumns._ID + ", "  +
                BlogModel.BlogColumns.COLUMN_NAME_TITLE + ", " +
                BlogModel.BlogColumns.COLUMN_NAME_DATE + ", " +
                BlogModel.BlogColumns.COLUMN_NAME_CONTENT  + " FROM " +
                BlogModel.BlogColumns.TABLE_NAME, null);

        List<BlogModel> list = new ArrayList<>();

        while ( mCursor.moveToNext() ){
            BlogModel blog = new BlogModel();
            blog.setId(mCursor.getInt(mCursor.getColumnIndex(BlogModel.BlogColumns._ID)));
            blog.setTitle(mCursor.getString(mCursor.getColumnIndex(BlogModel.BlogColumns.COLUMN_NAME_TITLE)));
            blog.setDate(mCursor.getString(mCursor.getColumnIndex(BlogModel.BlogColumns.COLUMN_NAME_DATE)));
            blog.setContent(mCursor.getString(mCursor.getColumnIndex(BlogModel.BlogColumns.COLUMN_NAME_CONTENT)));

            list.add(blog);
        }

        mCursor.close();
        db.close();
        return list;
    }

    public BlogModel getBlogById(BlogModel blogModel){
        SQLiteDatabase  db = this.getWritableDatabase();
        Cursor mCursor = db.rawQuery("SELECT " + BlogModel.BlogColumns._ID + ", "  +
                BlogModel.BlogColumns.COLUMN_NAME_TITLE + ", " +
                BlogModel.BlogColumns.COLUMN_NAME_DATE + ", " +
                BlogModel.BlogColumns.COLUMN_NAME_CONTENT  + " FROM " +
                BlogModel.BlogColumns.TABLE_NAME + " WHERE " +
                BlogModel.BlogColumns._ID +" = "+blogModel.getId(), null);

        BlogModel blog = new BlogModel();

        while ( mCursor.moveToNext() ){
            blog.setId(mCursor.getInt(mCursor.getColumnIndex(BlogModel.BlogColumns._ID)));
            blog.setTitle(mCursor.getString(mCursor.getColumnIndex(BlogModel.BlogColumns.COLUMN_NAME_TITLE)));
            blog.setDate(mCursor.getString(mCursor.getColumnIndex(BlogModel.BlogColumns.COLUMN_NAME_DATE)));
            blog.setContent(mCursor.getString(mCursor.getColumnIndex(BlogModel.BlogColumns.COLUMN_NAME_CONTENT)));
        }

        mCursor.close();
        db.close();
        return blog;
    }

    public void insertBlog(BlogModel blog){
        SQLiteDatabase  db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(BlogModel.BlogColumns.COLUMN_NAME_TITLE, blog.getTitle());
        values.put(BlogModel.BlogColumns.COLUMN_NAME_DATE, blog.getDate());
        values.put(BlogModel.BlogColumns.COLUMN_NAME_CONTENT, blog.getContent());

        db.insert(BlogModel.BlogColumns.TABLE_NAME, null, values);
    }
}
