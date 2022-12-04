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
    TextView exit;
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
        exit=findViewById(R.id.exit);
        quizId = getIntent().getStringExtra("quizId");
        id=findViewById(R.id.quizId);
        id.setText("qid: "+quizId);
        Hooks();
        list=new ArrayList<>();
        list.add(new modelclass("How do you insert COMMENTS in C++ code?","/* This is a comment","// This is a comment","# This is a comment","\\ This is a comment","// This is a comment"));
        list.add(new modelclass("Which data type is used to create a variable that should store text?","string","int","float","letter","string"));
        list.add(new modelclass("How do you create a variable with the numeric value 5?","double x = 5 ;","int x = 5 ;","x = 5 ;","num x = 5 ;","int x = 5 ;"));
        list.add(new modelclass("How do you create a variable with the floating number 2.8?","byte x = 2.8 ;","double x = 2.8 ;","x = 2.8 ;","int x = float(2.800) ;","double x = 2.8 ;"));
        list.add(new modelclass("Which method can be used to find the length of a string?","getSize();","length();","getLength();","len()","length();"));
        list.add(new modelclass("Which operator is used to add together two values?","*","+","%","++","+"));
        list.add(new modelclass("Which header file lets us work with input and output objects?","#incude <stream>","#include <i/ostream>","#include <iostream>","#include <inoutstream>","#include <iostream>"));
        list.add(new modelclass("To declare an array in C++, define the variable type with:","{}","[]","size()","()","[]"));
        list.add(new modelclass("Which keyword is used to create a class in C++?","class()","class","Myclass","CLASS","class"));
        list.add(new modelclass("How do you create a function in C++?","funcName=>{...}","funcName[]{...}","funcName(){...}","(funcName){...}","funcName(){...}"));

        total=list.size();
        allQuestions=list;
        total=allQuestions.size();
        Collections.shuffle(allQuestions);
        Modelclass = list.get(index);
        nextBtn.setClickable(false);
        setAllData();

        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(quizpage.this,TestFragment.class));
            }
        });
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
        finish();
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