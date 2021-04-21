package com.example.foodrythm.ui;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.foodrythm.R;
import com.example.foodrythm.models.Recipe;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipeDetailFragment extends Fragment {
        @BindView(R.id.imageUrlImageView) ImageView mImageLabel;
        @BindView(R.id.recipeNameTextView) TextView mNameLabel;
        @BindView(R.id.socialRankTextView) TextView mSocialRankLabel;
        @BindView(R.id.sourceUrlTextView) TextView mSourceUrlLabel;
        @BindView(R.id.saveRecipeButton) TextView mSaveRecipeButton;

        private Recipe mRecipe;

    public RecipeDetailFragment() {
            // Required empty public constructor
        }

        public static RecipeDetailFragment newInstance(Recipe recipe) {
            RecipeDetailFragment recipeDetailFragment = new RecipeDetailFragment();
            Bundle args = new Bundle();
            args.putParcelable("recipe", Parcels.wrap(recipe));
            recipeDetailFragment.setArguments(args);
            return recipeDetailFragment;
        }

        @Override
        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            assert getArguments() != null;
            mRecipe = Parcels.unwrap(getArguments().getParcelable("recipe"));
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            // Inflate the layout for this fragment

            View view =  inflater.inflate(R.layout.fragment_recipe_detail, container, false);
            ButterKnife.bind(this, view);
            Picasso.get().load(mRecipe.getImageUrl()).into(mImageLabel);

            List<String> categories = new ArrayList<>();

            mNameLabel.setText(mRecipe.getTitle());
            mSourceUrlLabel.setText(android.text.TextUtils.join(", ", categories));
            mSocialRankLabel.setText(Double.toString(mRecipe.getSocialRank()) + "/100");

            return view;
        }
}