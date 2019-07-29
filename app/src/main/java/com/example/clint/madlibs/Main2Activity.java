package com.example.clint.madlibs;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.ThreadLocalRandom;

public class Main2Activity extends AppCompatActivity {

    Story story;
    Button button;
    EditText textBox;
    ArrayList<Integer> storyIds = new ArrayList<>(Arrays.asList(R.raw.madlib1_tarzan,
                                                                R.raw.madlib2_university,
                                                                R.raw.madlib3_clothes,
                                                                R.raw.madlib4_dance));
    TextView wordCounter;

    // initialize menu
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        if(savedInstanceState != null) {
            story = (Story) savedInstanceState.getSerializable("story");
        }
        else {
            InputStream is = getResources().openRawResource(storyIds.get(ThreadLocalRandom.current()
                                                                    .nextInt(0, 4)));
            if (getIntent().getIntExtra("story", 7) != 7) {
                is = getResources().openRawResource(storyIds.get(getIntent()
                                                            .getIntExtra("story",
                                                                    0)));
            }
            story = new Story(is);
        }
        button = findViewById(R.id.nextWord);
        textBox = findViewById(R.id.editText);
        textBox.setHint(story.getNextPlaceholder());
        wordCounter = findViewById(R.id.wordsLeft);
        wordCounter.setText(String.format(Locale.US, "%d Words left!",
                                          story.getPlaceholderRemainingCount()));
    }

    // input words, else go to display activity
    @SuppressLint("SetTextI18n")
    public void onClick(View v) {
        int wordsLeft = story.getPlaceholderRemainingCount();
        Log.d("Added", textBox.getText().toString());
        story.fillInPlaceholder(textBox.getText().toString());
        if (story.getPlaceholderRemainingCount() > 0){
            textBox.setHint(story.getNextPlaceholder());
            textBox.setText("");
            if (wordsLeft != 1) {
                Log.d("Words left:", Integer.toString(story.getPlaceholderCount()));
                wordCounter.setText(Integer.toString(wordsLeft) + " Words left!");
            }
            else {
                wordCounter.setText("1 word left!");
            }

        }
        else {
            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
            intent.putExtra("story", story);
            startActivity(intent);
        }
    }

    // save instance in case of closing or rotating the app
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("story", story);
    }
}
