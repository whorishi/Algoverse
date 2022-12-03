package com.example.algoverse;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class quizpage extends AppCompatActivity {




    public ArrayList<modelclass> list;
    List<modelclass> allQuestions;
    modelclass Modelclass;
    int index=0;
    LinearLayout nextBtn;
    TextView cardQuestion,OptionA,OptionB,OptionC,OptionD;
    CardView cvA,cvB,cvC,cvD;
    int correctCount=0;
    int wrongCount=0;
    int total=0;
    String quizId;
    TextView id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quizpage);
        quizId = getIntent().getStringExtra("quizId");
        id=findViewById(R.id.quizId);
        id.setText("qid: "+quizId);
        Hooks();
        list=new ArrayList<>();
        list.add(new modelclass("what is c++?","language","scripting language","programming language","desining software","programming language"));
        list.add(new modelclass("what is java?","language","scripting language","programming language","desining software","language"));
        list.add(new modelclass("what is python?","language","scripting language","programming language","desining software","scripting language"));
        total=list.size();
        allQuestions=list;
        total=allQuestions.size();
        Collections.shuffle(allQuestions);
        Modelclass = list.get(index);
        nextBtn.setClickable(false);
        setAllData();
    }

    private void setAllData() {
        cardQuestion.setText(Modelclass.getQuestion());
        OptionA.setText(Modelclass.getOA());
        OptionB.setText(Modelclass.getOB());
        OptionC.setText(Modelclass.getOC());
        OptionD.setText(Modelclass.getOD());
    }

    private void Hooks() {
        cardQuestion = findViewById(R.id.cardQuestion);
        OptionA = findViewById(R.id.OA);
        OptionB=findViewById(R.id.OB);
        OptionC=findViewById(R.id.OC);
        OptionD=findViewById(R.id.OD);

        cvA=findViewById(R.id.CVOA);
        cvB=findViewById(R.id.CVOB);
        cvC=findViewById(R.id.CVOC);
        cvD=findViewById(R.id.CVOD);

        nextBtn = findViewById(R.id.nextBtn);
    }

    public void Correct(CardView cv) {
        //correctCount++;
        cv.setCardBackgroundColor(getResources().getColor(R.color.green));
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                index++;
                Modelclass = list.get(index);
                resetColor();
                setAllData();
                enableButton();
            }
        });
    }

    public void Wrong(CardView cv){
        //wrongCount++;
        cv.setCardBackgroundColor(getResources().getColor(R.color.red));
        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                if(index<list.size()-1){
                    index++;
                    Modelclass = list.get(index);
                    resetColor();
                    setAllData();
                    enableButton();
                }else{
                    GameWon();
                }
            }
        });
    }

    private void GameWon() {
        Intent intent=new Intent(quizpage.this,resultpage.class);
        intent.putExtra("correct",correctCount);
        intent.putExtra("wrong",total-correctCount);
        intent.putExtra("total",total);
        intent.putExtra("quizid",quizId);
        startActivity(intent);
    }

    public void enableButton(){
        cvA.setClickable(true);
        cvB.setClickable(true);
        cvC.setClickable(true);
        cvD.setClickable(true);
    }

    public void disableButton(){
        cvA.setClickable(false);
        cvB.setClickable(false);
        cvC.setClickable(false);
        cvD.setClickable(false);
    }

    public void resetColor(){
        cvA.setCardBackgroundColor(getResources().getColor(R.color.white));
        cvB.setCardBackgroundColor(getResources().getColor(R.color.white));
        cvC.setCardBackgroundColor(getResources().getColor(R.color.white));
        cvD.setCardBackgroundColor(getResources().getColor(R.color.white));

    }

    public void OAClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if(Modelclass.getOA().equals(Modelclass.getAns())){
            correctCount++;
            cvA.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index<list.size()-1)
            {
                Correct(cvA);
            }
            else
            {
                GameWon();
            }
        }
        else{
            wrongCount++;
            Wrong(cvA);
        }
    }

    public void OBClick(View view) {
        disableButton();
        nextBtn.setClickable(true);

        if(Modelclass.getOB().equals(Modelclass.getAns())){
            correctCount++;
            cvB.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index<list.size()-1)
            {

                Correct(cvB);
            }
            else
            {
                GameWon();
            }
        }
        else{
            wrongCount++;
            Wrong(cvB);
        }
    }

    public void OCClick(View view) {
        disableButton();
        nextBtn.setClickable(true);

        if(Modelclass.getOC().equals(Modelclass.getAns())){
            correctCount++;
            cvC.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index<list.size()-1)
            {

                Correct(cvC);
            }
            else
            {
                GameWon();
            }
        }
        else{
            wrongCount++;
            Wrong(cvC);
        }
    }

    public void ODClick(View view) {
        disableButton();
        nextBtn.setClickable(true);
        if(Modelclass.getOD().equals(Modelclass.getAns())){
            correctCount++;
            cvD.setCardBackgroundColor(getResources().getColor(R.color.green));
            if(index<list.size()-1)
            {
                Correct(cvD);
            }
            else
            {
                GameWon();
            }
        }
        else{
            wrongCount++;
            Wrong(cvD);
        }
    }
}