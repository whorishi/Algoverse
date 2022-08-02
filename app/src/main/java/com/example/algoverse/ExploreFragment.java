package com.example.algoverse;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ExploreFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class ExploreFragment extends Fragment {

    public ExploreFragment() {
        // Required empty public constructor
    }

    public Button arraybtn;
    public Button stackbtn;
    public Button queuebtn;
    public Button linkedlistbtn;
    public Button treebtn;
    public Button graphbtn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_explore, container, false);
        arraybtn = view.findViewById(R.id.arraybutton);
        arraybtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ExploreToArray= new Intent(getContext(),ArrayScreen.class);
                startActivity(ExploreToArray);
            }
        });
        //Navigate to stack
        stackbtn=view.findViewById(R.id.stackbutton);
        stackbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ExploreToStack= new Intent(getContext(),StackScreen.class);
                startActivity(ExploreToStack);
            }
        });
        //Navigate to queue
        queuebtn=view.findViewById(R.id.queuebutton);
        queuebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ExploreToQueue= new Intent(getContext(),QueueScreen.class);
                startActivity(ExploreToQueue);
            }
        });
        //Navigate to linked list
        linkedlistbtn=view.findViewById(R.id.linkedlistbutton);
        linkedlistbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ExploreToLinkedList= new Intent(getContext(),LinkedList.class);
                startActivity(ExploreToLinkedList);
            }
        });
        //Navigate to tree
        treebtn=view.findViewById(R.id.treebutton);
        treebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ExploreToTree= new Intent(getContext(),TreeScreen.class);
                startActivity(ExploreToTree);
            }
        });
        //Navigate to graph
        graphbtn=view.findViewById(R.id.graphbutton);
        graphbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ExploreToGraph = new Intent(getContext(), GraphScreen.class);
                startActivity(ExploreToGraph);
            }
        });

        return view;
    }
}