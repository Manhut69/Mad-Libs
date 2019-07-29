package com.example.clint.madlibs;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    Story story;

    // initialize and display text
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        story = (Story) getIntent().getSerializableExtra("story");
        TextView textView = findViewById(R.id.storyView);
        textView.setText(Html.fromHtml(story.toString(), Html.FROM_HTML_MODE_COMPACT));
    }

    // button press to go back to the start
    public void returnToStart(View v){
        Intent intent = new Intent(Main3Activity.this, MainActivity.class);
        startActivity(intent);
    }

    // in case the back button is pressed, go back to the start
    @Override
    public void onBackPressed(){
        returnToStart(findViewById(R.id.returnButton));
    }
}
