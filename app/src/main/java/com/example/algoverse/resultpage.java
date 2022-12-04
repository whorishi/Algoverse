package com.example.algoverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class resultpage extends AppCompatActivity {

    String quizId;
    TextView id;
    CircularProgressBar circularProgressBar;
    TextView score;
    int Correct,Wrong,Total;
    TextView share;
    TextView exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultpage);
        Correct=getIntent().getIntExtra("correct",0);
        Wrong=getIntent().getIntExtra("wrong",0);
        Total=getIntent().getIntExtra("total",0);
        quizId=getIntent().getStringExtra("quizid");
        exit=findViewById(R.id.exit);
        share=findViewById(R.id.shareBtn);
        id=findViewById(R.id.quizId);
        circularProgressBar=findViewById(R.id.circularProgressBar);
        score=findViewById(R.id.score);
        id.setText("qid: "+quizId);
        score.setText(Correct+"/"+Total);

        circularProgressBar.setProgress(Correct);
        circularProgressBar.setProgressMax(Total);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent shareIntent = new Intent(Intent.ACTION_SEND);
                    shareIntent.setType("text/plain");
                    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "My application name");
                    String shareMessage= "I scored "+Correct+"/"+Total +" on Algoverse Quizzes";
                    shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID +"\n\n";
                    shareIntent.putExtra(Intent.EXTRA_TEXT, shareMessage);
                    startActivity(Intent.createChooser(shareIntent, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(resultpage.this,TestFragment.class));
            }
        });

    }
}