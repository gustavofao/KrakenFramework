package com.kraken.cache;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

@SuppressLint("CommitPrefEdits") 
public class Cache extends com.kraken.config.MainConfig{
	
	SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context context;
    
    private static final int PRIVATE_MODE = 0;
    private String[] tags;
    private Integer[] tagType;
    
    public Cache(Context context){
    	this.context = context;
    	tags = cacheConfig.tags;
    	tagType = cacheConfig.tagType;
    	pref = context.getSharedPreferences(cacheConfig.CacheName, PRIVATE_MODE);
        editor = pref.edit();
    }
    
    
    
}
