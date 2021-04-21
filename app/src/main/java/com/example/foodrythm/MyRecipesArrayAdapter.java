package com.example.foodrythm;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyRecipesArrayAdapter extends ArrayAdapter {
    private Context mContext;
    private String[] mDessertRecipes;
    private String[] mCookingTime;

    public MyRecipesArrayAdapter(Context mContext, int resource, String[] mDessertRecipes) {
        super(mContext, resource);
        this.mContext = mContext;
        this.mDessertRecipes = mDessertRecipes;
        this.mCookingTime = mCookingTime;
    }

    @Override
    public Object getItem(int position) {
        String dessertRecipes = mDessertRecipes[position];
        String cookingTime = mCookingTime[position];
        return String.format("%s \nCooks for about %s", dessertRecipes, cookingTime);
    }

    @Override
    public int getCount() {
        return mDessertRecipes.length;
    }
}
