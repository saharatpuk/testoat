package com.example.nsc2018.testoat.model;

/**
 * Created by NSC2018 on 12/8/2017.
 */

public class DataItem {
    public final int id;
    public final String username;
    public final String password;

    public DataItem(int id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    @Override
    public String toString() {
        return username;
    }
}
