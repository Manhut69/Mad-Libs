package com.example.clint.madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.InputStream;
import java.util.ArrayList;

public class Main2Activity extends AppCompatActivity {

    ArrayList<String> inputWords = new ArrayList<>();
    Story story;
    Button button;
    EditText textBox;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        InputStream is = getResources().openRawResource(R.raw.madlib0_simple);
        story = new Story(is);
        button = findViewById(R.id.nextWord);
        textBox = findViewById(R.id.editText);
        textBox.setHint(story.getNextPlaceholder());
    }

    public void onClick(View v) {

            inputWords.add(textBox.getText().toString());
            Log.d("Added", textBox.getText().toString());
            story.fillInPlaceholder(textBox.getText().toString());
        if (story.getPlaceholderRemainingCount() > 1){
            textBox.setHint(story.getNextPlaceholder());
            textBox.setText("");
        }
        else {
            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
        }
    }
}
