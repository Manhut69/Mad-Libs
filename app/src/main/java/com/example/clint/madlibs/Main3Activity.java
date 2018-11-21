package com.example.clint.madlibs;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        story = (Story) getIntent().getSerializableExtra("story");
        TextView textView = findViewById(R.id.storyView);
        textView.setText(Html.fromHtml(story.toString(), Html.FROM_HTML_MODE_COMPACT));
    }

    public void returnToStart(View v){
        Intent intent = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        returnToStart(findViewById(R.id.returnButton));
    }
}
