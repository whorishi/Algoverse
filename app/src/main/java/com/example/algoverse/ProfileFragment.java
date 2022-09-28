package com.example.algoverse;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Objects;

public class ProfileFragment extends Fragment {

    FirebaseAuth mAuth;
    Button logoutButton;
    FirebaseFirestore fstore;
    ImageView profileImage;
    String userID;
    TextView fname;
    TextView Email;

    public ProfileFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        mAuth = FirebaseAuth.getInstance();
        fstore = FirebaseFirestore.getInstance();
        FirebaseUser user= mAuth.getCurrentUser();
        profileImage = view.findViewById(R.id.profileImageId);
        fname=view.findViewById(R.id.profileNameTextView);
        Email=view.findViewById(R.id.profileEmailTextVew);
        userID= Objects.requireNonNull(mAuth.getCurrentUser()).getUid();
        DocumentReference documentReference= fstore.collection("users").document(userID);
        documentReference.get().addOnSuccessListener(new OnSuccessListener<DocumentSnapshot>() {
            @Override
            public void onSuccess(DocumentSnapshot documentSnapshot) {
                fname.setText(documentSnapshot.getString("name"));
                Email.setText(documentSnapshot.getString("email"));
            }
        });

        logoutButton = view.findViewById(R.id.logoutbutton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mAuth.signOut();
                startActivity(new Intent(getActivity(),login.class));
                getActivity().finish();
            }
        });

        return view;
    }
}