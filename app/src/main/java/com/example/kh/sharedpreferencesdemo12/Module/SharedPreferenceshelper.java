package com.example.kh.sharedpreferencesdemo12.Module;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.Map;

/**
 * Created by kh on 4/26/2017.
 */

public class SharedPreferenceshelper {
    private static SharedPreferenceshelper preferenceshelper;

    public static  SharedPreferenceshelper getInstance(){
        if(preferenceshelper==null)
            preferenceshelper = new SharedPreferenceshelper();
        return preferenceshelper;
    }

    public String getData(Context context,String name){
        SharedPreferences sharedPreferences = context.getSharedPreferences("mydata",Context.MODE_PRIVATE);
       String data = sharedPreferences.getString(name,"not found");

        return data;



    }

    public void setData(Context context,String name, String data){
        SharedPreferences sharedPreferences = context.getSharedPreferences("mydata",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(name,data);
        editor.commit();
    }

    public void deleteData(Context context, String name){
        SharedPreferences sharedPreferences = context.getSharedPreferences("mydata",0);
        sharedPreferences.edit().remove(name).commit();
    }
    public String getAllData(Context context){
        SharedPreferences sharedPreferences = context.getSharedPreferences("mydata",context.MODE_PRIVATE);
       Map<String, ?> map =  sharedPreferences.getAll();
        StringBuffer stringBuffer = new StringBuffer();
        for(Map.Entry<String,?> entry: map.entrySet()){
         stringBuffer.append("Key: "+entry.getValue()+"\n")   ;
        }
        return stringBuffer.toString();

    }
}
