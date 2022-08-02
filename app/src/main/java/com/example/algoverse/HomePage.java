package com.example.algoverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    public Button arraybtn;
    public Button stackbtn;
    public Button queuebtn;
    public Button linkedlistbtn;
    public Button treebtn;
    public Button graphbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);


                    //Navigate to array
        arraybtn=findViewById(R.id.arraybutton);
        arraybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HomeToArray= new Intent(HomePage.this,ArrayScreen.class);
                Toast.makeText(getApplicationContext(),"LEARNING ARRAYS",Toast.LENGTH_SHORT).show();
                startActivity(HomeToArray);
            }
        });
                    //Navigate to stack
        stackbtn=findViewById(R.id.stackbutton);
        stackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HomeToStack= new Intent(HomePage.this,StackScreen.class);
                startActivity(HomeToStack);
            }
        });
                    //Navigate to queue
        queuebtn=findViewById(R.id.queuebutton);
        queuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HomeToQueue= new Intent(HomePage.this,QueueScreen.class);
                startActivity(HomeToQueue);
            }
        });
                    //Navigate to linked list
        linkedlistbtn=findViewById(R.id.linkedlistbutton);
        linkedlistbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HomeToLinkedList= new Intent(HomePage.this,LinkedList.class);
                startActivity(HomeToLinkedList);
            }
        });
                    //Navigate to tree
        treebtn=findViewById(R.id.treebutton);
        treebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HomeToTree= new Intent(HomePage.this,TreeScreen.class);
                startActivity(HomeToTree);
            }
        });
                    //Navigate to graph
        graphbtn=findViewById(R.id.graphsbutton);
        graphbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent HomeToGraph= new Intent(HomePage.this,GraphScreen.class);
                startActivity(HomeToGraph);
            }
        });
    }
}