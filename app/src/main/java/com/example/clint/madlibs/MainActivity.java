package com.example.clint.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

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
