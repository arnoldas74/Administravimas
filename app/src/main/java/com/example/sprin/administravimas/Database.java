package com.example.sprin.administravimas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper{
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "db";

    private static final String TABLE_USERS = "users";
    private static final String USER_ID = "id";
    private static final String USER_LEVEL = "userlevel";
    private static final String USER_NAME = "name";
    private static final String USER_PASSWORD = "password";
    private static final String USER_EMAIL = "email";

    private static final String ADMINISTRATION_ASSIGNMENT = "assignment";
    private static final String ADMINISTRATION_DONE = "done";


    public Database(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_USERS + "("
                + USER_ID + " INTEGER PRIMARY KEY,"
                + USER_LEVEL + " TEXT,"
                + USER_NAME + " TEXT,"
                + USER_PASSWORD + " TEXT,"
                + USER_EMAIL + " TEXT," + ")";
        db.execSQL(CREATE_USERS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USERS);

        onCreate(db)
    }
    void addUser(User user) {
                SQLiteDatabase db = this.getWritableDatabase();

                        ContentValues values = new ContentValues();
                values.put(USER_LEVEL,      user.getUserlevel());
                values.put(USER_NAME,       user.getUsernameForRegister());
                values.put(USER_PASSWORD,   user.getPasswordForRegister());
                values.put(USER_EMAIL,      user.getEmailForRegister());

                        // Inserting Row
                                db.insert(TABLE_USERS, null, values);

                        // Closing database connection
                                db.close();
            }

}