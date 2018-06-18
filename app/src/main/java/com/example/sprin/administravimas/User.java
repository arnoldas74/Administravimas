package com.example.sprin.administravimas;

import android.content.Context;

public class User {
    private int id;
    private String userlevel;
    private String username;
    private String password;
    private String email;
    private static final String PREFERENCES_FILE_NAME = "com.example.sprin.administravimas";
    private static final String USERNAME_KEY = "username";
    private static final String PASSWORD_KEY = "password";
    private static final String REMEMBER_ME_KEY = "rememberMe";

    private SharedPreferences sharedPreferences;

    public User(){
    }




    public User(String userlevel, String username, String password, String email){
        this.userlevel = userlevel;
        this.username = username;
        this.password = password;
        this.email = email;

        public User(Context context) {
            this.sharedPreferences = context.getSharedPreferences
                    (User.PREFERENCES_FILE_NAME, Context.MODE_PRIVATE);
        }

        public String getUsernameForLogin() {
            return this.sharedPreferences.getString(USERNAME_KEY,"");
        }
        public void setUsernameForLogin(String username) {
            this.sharedPreferences.edit().putString(USERNAME_KEY,username).commit();
        }
        public void setUsernameForRegister(String username) {
            this.username = username;
        }

    }
    public String getUserlevel() {
        return userlevel;
    }

    public void setUserlevel(String userlevel) {
        this.userlevel = userlevel;
    }
    public void setPasswordForLogin(String password) {
        this.sharedPreferences.edit().putString(PASSWORD_KEY,password).commit();
    }
    public boolean isRemembered(){
        return this.sharedPreferences.getBoolean(REMEMBER_ME_KEY,false);
    }
    public void setRememberMeKeyForLogin(boolean rememberMe){
        this.sharedPreferences.edit().putBoolean(REMEMBER_ME_KEY,rememberMe).commit();
    }
    //sitie geteriai seteriai skirti register activity langui
    public String getUsernameForRegister() {
        return username;
    }
    public void setUsernameForRegister(String username) {
        this.username = username;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPasswordForRegister() {
        return password;
    }
    public void setPasswordForRegister(String password) {
        this.password = password;
    }
    public String getEmailForRegister() {
        return email;
    }
    public void setEmailForRegister(String email) {
        this.email = email;
    }
    }


