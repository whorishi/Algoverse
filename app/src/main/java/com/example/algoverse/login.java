package com.example.algoverse;

import android.content.DialogInterface;
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
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class login extends AppCompatActivity {
     private FirebaseAuth mAuth;
    final String TAG="login";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mAuth = FirebaseAuth.getInstance();
        Button loginbutton =findViewById(R.id.loginbutton);
        final EditText emailInput = findViewById(R.id.logineditTextTextEmailAddress);
        final EditText passwordInput = findViewById(R.id.logineditTextTextPassword);
        TextView registerclick = findViewById(R.id.registerlink);
        TextView forgotPasswordLink = findViewById(R.id.forgotPassword);

        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Email=emailInput.getText().toString().trim();
                String Password= passwordInput.getText().toString().trim();
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

                login(emailInput.getText().toString(),passwordInput.getText().toString());
            }
        });

        registerclick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(login.this, register.class ));
                finish();
            }
        });

        forgotPasswordLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText resetmail = new EditText(view.getContext());
                final AlertDialog.Builder passwordResetDialog = new AlertDialog.Builder(view.getContext());
                passwordResetDialog.setTitle("Reset Password ?");
                passwordResetDialog.setMessage("Enter your Email");
                passwordResetDialog.setView(resetmail);

                passwordResetDialog.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {

                        String email=resetmail.getText().toString();
                        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful())
                                {
                                    Toast.makeText(login.this, "Reset Link sent to "+ email, Toast.LENGTH_SHORT).show();
                                }
                                else
                                {
                                    Toast.makeText(login.this, "Error! "+ task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
                    }
                });

                passwordResetDialog.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //do nothing
                    }
                });

                passwordResetDialog.create().show();
            }
        });
    }


    private void login(String email,String password)
    {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            Toast.makeText(login.this, "Login Success.",
                                    Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(login.this, mainPage.class));
                            finish();
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(login.this, "Error! "+task.getException().getMessage(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        FirebaseUser user = mAuth.getCurrentUser();
        if(user != null) {
            startActivity(new Intent(login.this, mainPage.class));
            finish();
        }
    }
}
