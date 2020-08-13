package com.example.myapplication10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button trueBtn;
    private Button falseBtn;
    private Button cheatBtn;
    private TextView questionTextView;
    private Question[] questionBank = new Question[]{
      new Question(R.string.question_text,true),
      new Question(R.string.question_text1,false),
      new Question(R.string.question_text2,false),
      new Question(R.string.question_text3,false),
      new Question(R.string.question_text4,true)
    };
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("MainActivity","Метод onCreate() запущен!");
        if (savedInstanceState != null)
            currentIndex = savedInstanceState.getInt("currentIndex");

        setContentView(R.layout.activity_main);

        trueBtn = (Button) findViewById(R.id.true_btn);
        falseBtn= (Button) findViewById(R.id.false_btn);
        cheatBtn= (Button) findViewById(R.id.cheat_Btn);
        questionTextView = (TextView) findViewById(R.id.question_text_view);
        int question = questionBank[currentIndex].getTextResId();
        questionTextView.setText(question);

        cheatBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,CheatActivity.class);
                intent.putExtra("isAnswerTrue",questionBank[currentIndex].isAnswerTrue());
                startActivity(intent);
            }
        });

        trueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(true);
            }
        });

        falseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkAnswer(false);
            }
        });
    }
    private void checkAnswer(boolean userAnswer){
        if (questionBank[currentIndex].isAnswerTrue() == userAnswer)
            Toast.makeText(MainActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(MainActivity.this,R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        currentIndex = (currentIndex+1)%questionBank.length;
        int question = questionBank[currentIndex].getTextResId();
        questionTextView.setText(question);
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        Log.d("MainActivity","Метод onSaveInstanceState() запущен!");
        savedInstanceState.putInt("currentIndex",currentIndex);
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d("MainActivity","Метод onStart() запущен!");
    }
    @Override
    public void onResume(){
        super.onResume();
        Log.d("MainActivity","Метод onResume() запущен!");
    }
    @Override
    public void onPause(){
        super.onPause();
        Log.d("MainActivity","Метод onPause() запущен!");
    }
    @Override
    public void onStop(){
        super.onStop();
        Log.d("MainActivity","Метод onStop() запущен!");
    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d("MainActivity","Метод onDestroy() запущен!");
    }
}