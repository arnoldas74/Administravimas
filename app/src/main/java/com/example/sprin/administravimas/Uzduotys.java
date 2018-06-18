package com.example.sprin.administravimas;

public class Uzduotys {
    private int id;
    private String user;
    private String uzduotis;


    public Uzduotys (int id, String user, String uzduotis){
        this.id=id;
        this.user=user;
        this.uzduotis=uzduotis;

    }
    public Uzduotys(String uzduotis){
        this.uzduotis=uzduotis;
    }
    public int getId() {return id;}

    public void setId(int id) {this.id = id;}

    public String getUser() {return user;}

    public void setUser(String user) {this.user = user;}

    public String getUzduotis() {return uzduotis;}

    public void setUzduotis(String uzduotis) {this.uzduotis = uzduotis;}
}
