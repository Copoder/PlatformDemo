package com.iunin.demo.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by copo on 17-11-15.
 */

public class CongifUtil {
    private Context context;
    private SharedPreferences mSpf;
    private SharedPreferences.Editor mEdit;

    public CongifUtil(Context context){
        this.context = context;
        mSpf = context.getSharedPreferences(Constans.CONFIG_INFO,Context.MODE_PRIVATE);
        mEdit = mSpf.edit();
    }

    public void putString(String key,String value){
        mEdit.putString(key,value);
    }

    public String getString(String key,String def){
        return mSpf.getString(key,def);
    }

    public void putInt(String key,int value){
        mEdit.putInt(key,value);
    }

    public int getInt(String key,int def){
        return mSpf.getInt(key,def);
    }

    public void putBoolean(String key,boolean value){
        mEdit.putBoolean(key,value);
    }

    public boolean getBoolean(String key,boolean def){
        return mSpf.getBoolean(key,def);
    }



}
