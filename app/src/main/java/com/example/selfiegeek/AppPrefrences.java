package com.example.selfiegeek;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by DU on 4/17/2017.
 */

public class AppPrefrences  {
    public static final String PREF_NAME = "SelfieGeek";

    public static final int MODE = Context.MODE_APPEND;
    private static final String KEY_IMAGE_LIST = "imagelist";
    private static final String  KEY_VIDEO_LIST = "videolist";
    Set<String> imglist = new HashSet<String>();
    Set<String> vidlist = new HashSet<String>();

    public static SharedPreferences getPreferences(Context context) {
        return context.getSharedPreferences(PREF_NAME, MODE);
    }
    public static SharedPreferences.Editor getEditor(Context context) {
        return getPreferences(context).edit();
    }

    public Set getImageList(Context context) {

        return getPreferences(context).getStringSet(KEY_IMAGE_LIST, imglist);
    }
    public void setImageList(Context context, Set list){
        getEditor(context).putStringSet(KEY_IMAGE_LIST, list).apply();
    }

    public Set getVideoList(Context context) {

        return getPreferences(context).getStringSet(KEY_VIDEO_LIST, vidlist);
    }
    public void setVideoList(Context context, Set list){
        getEditor(context).putStringSet(KEY_VIDEO_LIST, list).apply();
    }
}
