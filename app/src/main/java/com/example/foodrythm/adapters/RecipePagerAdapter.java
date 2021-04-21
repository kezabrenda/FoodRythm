package com.example.foodrythm.adapters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.foodrythm.models.Recipe;
import com.example.foodrythm.ui.RecipeDetailFragment;

import java.util.List;

public class RecipePagerAdapter extends FragmentPagerAdapter {
    private List<Recipe> mRecipes;

    public RecipePagerAdapter(@NonNull FragmentManager fm, int behavior, List<Recipe> recipes) {
        super(fm, behavior);
        mRecipes = recipes;
    }

    @Override
    public Fragment getItem(int position) {
        return RecipeDetailFragment.newInstance(mRecipes.get(position));
    }

    @Override
    public int getCount() {
        return mRecipes.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mRecipes.get(position).getTitle();
    }
}
