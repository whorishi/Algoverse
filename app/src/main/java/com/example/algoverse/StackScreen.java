package com.example.algoverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class StackScreen extends AppCompatActivity {

    public Button stackTraversalbtn;
    public Button stackCreationbtn;
    public Button stackPushbtn;
    public Button stackPopbtn;
    public Button stackIsFullbtn;
    public Button stackIsEmptybtn;
    public Button stackPeakbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stack_screen);


        //Navigate from Stack to Traveral Page
        stackTraversalbtn=findViewById(R.id.stacktraversalbutton);
        stackTraversalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent StackToTraversal=new Intent(StackScreen.this,StackTraversalScreen.class);
                startActivity(StackToTraversal);
            }
        });

        //Navigate from Stack to Creation page
        stackCreationbtn=findViewById(R.id.stackcreationbutton);
        stackCreationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent StackToCreation=new Intent(StackScreen.this,StackCreationScreen.class);
                startActivity(StackToCreation);
            }
        });

        //Navigate from Stack to Push page
        stackPushbtn=findViewById(R.id.stackpushbutton);
        stackPushbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent StackToPush=new Intent(StackScreen.this,StackPushScreen.class);
                startActivity(StackToPush);
            }
        });

        //Navigate from Stack to Pop page
        stackPopbtn=findViewById(R.id.stackpopbutton);
        stackPopbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent StackToPop=new Intent(StackScreen.this,StackPopScreen.class);
                startActivity(StackToPop);
            }
        });

        //Navigate from Stack to IsFull page
        stackIsFullbtn=findViewById(R.id.stackisfullbutton);
        stackIsFullbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent StackToIsFull=new Intent(StackScreen.this,StackIsFullScreen.class);
                startActivity(StackToIsFull);
            }
        });

        //Navigate from Stack to IsEmpty page
        stackIsEmptybtn=findViewById(R.id.stackisemptybutton);
        stackIsEmptybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent StackToIsEmpty=new Intent(StackScreen.this,StackIsEmptyScreen.class);
                startActivity(StackToIsEmpty);
            }
        });

        //Navigate from Stack to Peak page
        stackPeakbtn=findViewById(R.id.stackpeakbutton);
        stackPeakbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent StackToPeak=new Intent(StackScreen.this,StackPeakScreen.class);
                startActivity(StackToPeak);
            }
        });


    }
}