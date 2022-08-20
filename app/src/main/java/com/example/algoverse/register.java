package com.example.algoverse;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class register extends AppCompatActivity {
    int x;
    private FirebaseAuth mAuth;
    final String TAG="register";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        mAuth = FirebaseAuth.getInstance();
        Button registerbutton=findViewById(R.id.registerbutton);
        EditText nameInput= findViewById(R.id.editTextTextPersonName);
        final EditText emailInput= findViewById(R.id.editTextTextEmailAddress);
        final EditText passwordInput= findViewById(R.id.editTextTextPassword);
        final EditText confirmpasswordInput = findViewById(R.id.editTextTextPassword2);
        TextView loginLink = findViewById(R.id.loginHere);

        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fullName= nameInput.getText().toString().trim();
                String Email=emailInput.getText().toString().trim();
                String Password=passwordInput.getText().toString().trim();
                String confirmPassword = confirmpasswordInput.getText().toString().trim();

                if(TextUtils.isEmpty(fullName))
                {
                    nameInput.setError("Name is required");
                }

                if(TextUtils.isEmpty(Email))
                {
                    emailInput.setError("Email is required");
                    return;
                }

                if(TextUtils.isEmpty(Password))
                {
                    passwordInput.setError("Password is required");
                    return;
                }

                if(Password.length() < 6)
                {
                    passwordInput.setError("Password must be >= 6 characters");
                    return;
                }

                if(!checkPasswordStrength(Password))
                {
                    passwordInput.setError("Password must contain at least one Lowercase, Uppercase and digit");
                    return;
                }
                Register(Email,Password);
            }
        });

        loginLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(register.this, login.class));
            }
        });
    }

    private void Register(String email,String password)
    {
        mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(register.this, "Authentication Success", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(getApplicationContext(),mainPage.class));
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(register.this, "Error! "+task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    public boolean checkPasswordStrength(String Password)
    {
        boolean hasLower=false;
        boolean hasUpper=false;
        boolean hasDigit=false;
        for(char j: Password.toCharArray()) {
            if (Character.isLowerCase(j)) {
                hasLower=(true);
            }
            if (Character.isUpperCase(j)) {
                hasUpper = true;
            }
            if (Character.isDigit(j)) {
                hasDigit = true;
            }
        }
        return hasLower&& hasUpper && hasDigit;
    }

}