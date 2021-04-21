package com.example.foodrythm.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodrythm.adapters.RecipeListAdapter;
import com.example.foodrythm.models.ForkifySearchResponse;
import com.example.foodrythm.MyRecipesArrayAdapter;
import com.example.foodrythm.R;
import com.example.foodrythm.models.Recipe;
import com.example.foodrythm.network.Api;
import com.example.foodrythm.network.Client;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipesActivity extends AppCompatActivity {
    public static final String TAG = RecipesActivity.class.getSimpleName();
    @BindView(R.id.errorTextView) TextView mErrorTextView;
    @BindView(R.id.progressBar) ProgressBar mProgressBar;
    @BindView(R.id.recyclerView) RecyclerView mRecyclerView;
    private RecipeListAdapter mAdapter;
    public List<Recipe> recipes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String foodType = intent.getStringExtra("foodType");
        Log.d( TAG, "In the onCreate method!");

        /*******************************************API********************************************/
        Api client = Client.getClient();
        Call<ForkifySearchResponse> call = client.getRecipes(foodType);

        call.enqueue(new Callback<ForkifySearchResponse>() {
            @Override
            public void onResponse(Call<ForkifySearchResponse> call, Response<ForkifySearchResponse> response) {
                hideProgressBar();

                if (response.isSuccessful()) {
                    recipes = response.body().getRecipes();
                    mAdapter = new RecipeListAdapter(RecipesActivity.this, recipes);
                    mRecyclerView.setAdapter(mAdapter);
                    RecyclerView.LayoutManager layoutManager =
                            new LinearLayoutManager(RecipesActivity.this);
                    mRecyclerView.setLayoutManager(layoutManager);
                    mRecyclerView.setHasFixedSize(true);


                   /* List<Recipe> ingredientsList = response.body().getRecipes();
                    String[] recipes = new String[ingredientsList.size()];

                    for (int i = 0; i < recipes.length; i++){
                        recipes[i] = ingredientsList.get(i).getTitle();
                    }


                    ArrayAdapter adapter
                            = new MyRecipesArrayAdapter(RecipesActivity.this, android.R.layout.simple_list_item_1, recipes);
                    mListView.setAdapter(adapter);*/
                    showRecipes();
                } else {
                    showUnsuccessfulMessage();
                }
            }

            @Override
            public void onFailure(Call<ForkifySearchResponse> call, Throwable t) {
                Log.e("Error Message", "onFailure: ",t );
                hideProgressBar();
                showFailureMessage();
            }

        });
    }
    private void showFailureMessage() {
        mErrorTextView.setText("Something went wrong. Please check your Internet connection and try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showUnsuccessfulMessage() {
        mErrorTextView.setText("Something went wrong. Please try again later");
        mErrorTextView.setVisibility(View.VISIBLE);
    }

    private void showRecipes() {
        mRecyclerView.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

}