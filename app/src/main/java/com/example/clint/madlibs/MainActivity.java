/*
   A simple Mad libs game where the user is prompted to input types of words, which are inserted in a text
   By Clint Nieuwendijk
 */
package com.example.clint.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // initialize app
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // button clicks for the different stories and go to the next activity
    public void gotoNext(View v) {
        Intent intent = new Intent(MainActivity.this, Main2Activity.class);
        switch (v.getId()) {
            case (R.id.storyRandom):
                intent.putExtra("story", 7);
                break;
            case (R.id.storyTarzan):
                intent.putExtra("story", 0);
                break;
            case (R.id.storyUni):
                intent.putExtra("story", 1);
                break;
            case (R.id.storyClothes):
                intent.putExtra("story", 2);
                break;
            case (R.id.storyDance):
                intent.putExtra("story", 3);
                break;
        }
        startActivity(intent);
    }

}
