package com.example.foodrythm.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.foodrythm.R;
import com.example.foodrythm.models.Recipe;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipesViewHolder> {
    private List<Recipe> mRecipes;
    private Context mContext;

    public RecipeListAdapter(Context context, List<Recipe> recipes) {
        mContext = context;
        mRecipes = recipes;
    }

    @Override
    public RecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_item, parent, false);
        RecipesViewHolder viewHolder = new RecipesViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecipesViewHolder holder, int position) {
        holder.bindRecipe(mRecipes.get(position));
    }

    @Override
    public int getItemCount() {
        return mRecipes.size();
    }

    public class RecipesViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.imageUrlImageView) ImageView mImageUrlImageView;
        @BindView(R.id.recipeNameTextView) TextView mNameTextView;
        @BindView(R.id.sourceUrlTextView) TextView mSourceUrlTextView;
        @BindView(R.id.socialRankTextView) TextView mSocialRankTextView;

        private Context mContext;

        public RecipesViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindRecipe(Recipe recipe) {
            Picasso.get().load(recipe.getImageUrl()).into(mImageUrlImageView);
            mNameTextView.setText(recipe.getTitle());
            mSourceUrlTextView.setText(recipe.getSourceUrl());
            mSocialRankTextView.setText("social_rank: " + recipe.getSocialRank());
        }
    }
}
