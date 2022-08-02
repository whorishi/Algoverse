package com.example.algoverse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ArrayScreen extends AppCompatActivity {
    public TextView arraybasicintro1,arraybasicintro2,arraybasicintro4;
    public Button arrayInsertionbtn,arrayDeletionbtn,arraySearchbtn,arrayUpdatebtn,arrayTraversalbtn,arrayCreationbtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array_screen);

        arraybasicintro1=findViewById(R.id.arrayContent1);
        arraybasicintro2=findViewById(R.id.arrayContent2);
        arraybasicintro4=findViewById(R.id.arrayContent4);
        arraybasicintro1.setText("In C++, an array is a variable that can store multiple values of the same type.\nIn C++, the size and type of arrays cannot be changed after its declaration.\n\nC++ ARRAY DECLARATION:");
        arraybasicintro2.setText("POINTS TO REMEMBER:\n\n</> The array indices start with 0. Meaning\n      x[0] is the first element stored at index 0.\n</> If the size of an array is n, the last\n      element is stored at index (n-1). In this\n      example, x[5] is the last element.\n </> Elements of an array have consecutive\n       addresses. For example, suppose the\n       starting address of x[0] is 2120. Then,\n       the address of the next element x[1]\n       will be 2124, the address of x[2] will\n       be 2128, and so on. Here, the size of\n       each element is increased by 4.\n This is because the size of int is 4 bytes.\n");
        arraybasicintro4.setText("C++ ARRAY OUT OF BOUNDS:\n    If we declare an array of size 10,\n    then the array will contain elements\n    from index 0 to 9.\n    However, if we try to access the element\n    at index 10 or more than 10, it will\n    result in Undefined Behaviour.\n");

                //Navigate to Insertion Screen
        arrayInsertionbtn=findViewById(R.id.arrayinsertionbutton);
        arrayInsertionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ArrayToInsertion= new Intent(ArrayScreen.this,ArrayInsertionScreen.class);
                Toast.makeText(ArrayScreen.this, "Inserting elements in Array", Toast.LENGTH_SHORT).show();
                startActivity(ArrayToInsertion);
            }
        });

                //Navigate to Deletion Screen
        arrayDeletionbtn=findViewById(R.id.arraydeletionbutton);
        arrayDeletionbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ArrayToDeletion= new Intent(ArrayScreen.this,ArrayDeletionScreen.class);
                Toast.makeText(ArrayScreen.this, "Deleting elements from Array", Toast.LENGTH_SHORT).show();
                startActivity(ArrayToDeletion);
            }
        });

                //Navigate to Search Screen
        arraySearchbtn=findViewById(R.id.arraysearchbutton);
        arraySearchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ArrayToSearch= new Intent(ArrayScreen.this,ArraySearchScreen.class);
                Toast.makeText(ArrayScreen.this, "Searching elements in Array", Toast.LENGTH_SHORT).show();
                startActivity(ArrayToSearch);
            }
        });

                //Navigate to Update Screen
        arrayUpdatebtn=findViewById(R.id.arrayupdatebutton);
        arrayUpdatebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ArrayToUpdate= new Intent(ArrayScreen.this,ArrayUpdateScreen.class);
                Toast.makeText(ArrayScreen.this, "Updating element of Array", Toast.LENGTH_SHORT).show();
                startActivity(ArrayToUpdate);
            }
        });

                //Navigate to Traversal Screen
        arrayTraversalbtn=findViewById(R.id.arraytraversingbutton);
        arrayTraversalbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ArrayToTraversal= new Intent(ArrayScreen.this,ArrayTraversalScreen.class);
                Toast.makeText(ArrayScreen.this, "Traverse the Array", Toast.LENGTH_SHORT).show();
                startActivity(ArrayToTraversal);
            }
        });

                //Navigate to Creation Screen
        arrayCreationbtn=findViewById(R.id.arraycreatebutton);
        arrayCreationbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ArrayToCreation= new Intent(ArrayScreen.this,ArrayCreationScreen.class);
                Toast.makeText(ArrayScreen.this, "Creating an Array", Toast.LENGTH_SHORT).show();
                startActivity(ArrayToCreation);
            }
        });

    }

}