package com.example.centaepoint.lokronguide;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Centaepoint on 1/6/2018.
 */
public class Datasource {
 private SharedPreferences sharedPreferences;
 private SharedPreferences.Editor editor;

    public static Datasource getInstance(){
        return new Datasource();
    }

    public void setName(Context context,String name){
        sharedPreferences = context.getSharedPreferences("name",context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.putString("name",name);
        editor.commit();
    }
    public String getName(Context context){
        sharedPreferences = context.getSharedPreferences("name",context.MODE_PRIVATE);
        return sharedPreferences.getString("name","");
    }
    public void ClearData(Context context){
        sharedPreferences = context.getSharedPreferences("name",context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
    }
}
