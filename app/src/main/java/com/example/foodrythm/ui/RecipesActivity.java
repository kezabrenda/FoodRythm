package com.example.foodrythm.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.foodrythm.MyRecipesArrayAdapter;
import com.example.foodrythm.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecipesActivity extends AppCompatActivity {
    public static final String TAG = RecipesActivity.class.getSimpleName();
    @BindView(R.id.foodTypeTextView) TextView mFoodTypeTextView;
    @BindView(R.id.listView) ListView mListView;

    private String[] dessertRecipes = new String[] {"Jell-O", "Pancakes",
            "Pies", "CupCakes", "Granola Bars", "Ice cream",
            "Cakes", "Pudding", "Souffle", "Frozen Yogurt",
            "Tart", "Beignets", "Banana Bread", "Cookies"};

    private String[] cookingTime = new String[] {"Hour", "One hour and a half", "Half hour", "Two hours", "Hour",
            "Half hour", "Two hours", "Hour", "Two and half hours", "Fifteen minutes", "Hour", "Thirty minutes",
            "Three hours", "Forty five minutes" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipes);
        ButterKnife.bind(this);

        MyRecipesArrayAdapter adapter = new MyRecipesArrayAdapter(this, android.R.layout.simple_list_item_1, dessertRecipes, cookingTime);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String dessert = ((TextView)view).getText().toString();
                Toast.makeText(RecipesActivity.this, dessert, Toast.LENGTH_LONG).show();
                Log.v( TAG, "In the onItemClickListener!");
            }
        });

        Intent intent = getIntent();
        String foodType = intent.getStringExtra("foodType");
        mFoodTypeTextView.setText("Here are all the related recipes: " + foodType);
        Log.d( TAG, "In the onCreate method!");
    }
}