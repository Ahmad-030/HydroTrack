package com.example.hydrotrack;

import android.content.Context;
import android.content.SharedPreferences;

public class PrefManager {

    SharedPreferences sp;
    SharedPreferences.Editor editor;

    public PrefManager(Context context) {
        sp = context.getSharedPreferences("HydroTrack", Context.MODE_PRIVATE);
        editor = sp.edit();
    }

    public void setWater(int water) {
        editor.putInt("water", water).apply();
    }

    public int getWater() {
        return sp.getInt("water", 0);
    }

    public void setTarget(int target) {
        editor.putInt("target", target).apply();
    }

    public int getTarget() {
        return sp.getInt("target", 0);
    }

    public void setWeight(int weight) {
        editor.putInt("weight", weight).apply();
    }

    public int getWeight() {
        return sp.getInt("weight", 0);
    }

    public void clearAll() {
        editor.clear().apply();
    }
}