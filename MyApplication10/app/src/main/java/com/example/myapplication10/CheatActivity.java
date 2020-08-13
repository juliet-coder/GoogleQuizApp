package com.example.myapplication10;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {

    private boolean isAnswerTrue;
    private TextView cheatTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        isAnswerTrue = getIntent().getBooleanExtra("isAnswerTrue",false);
        cheatTextView = (TextView) findViewById(R.id.cheatTextView);
        cheatTextView.setText(isAnswerTrue?"ДА":"НЕТ"); 
    }
}
