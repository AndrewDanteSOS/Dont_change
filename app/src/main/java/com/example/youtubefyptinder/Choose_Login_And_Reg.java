package com.example.youtubefyptinder;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Choose_Login_And_Reg extends AppCompatActivity {

    private Button mLogin, mRegister;
    private FirebaseAuth mAuth;
    private ProgressBar spinner;
    public String TAG;
    private FirebaseAuth.AuthStateListener firebaseAuthStateListener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_login_and_reg);
        TAG = "chooseLoginRegistration";
        mAuth = FirebaseAuth.getInstance();
        spinner = (ProgressBar)findViewById(R.id.pBar);
        spinner.setVisibility(View.GONE);
        if(mAuth != null){
            final FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
            if (user !=null && user.isEmailVerified()){  //uncomment for production
                //  if (user !=null ){
                spinner.setVisibility(View.VISIBLE);
                Intent intent = new Intent(Choose_Login_And_Reg.this, MainActivity.class);
                startActivity(intent);
                finish();
                spinner.setVisibility(View.GONE);
                return;
            }
            else {
                Log.d(TAG, "user is null");
            }
        }


        mLogin = (Button) findViewById(R.id.login);
        mRegister = (Button) findViewById(R.id.register);

        mLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner.setVisibility(View.VISIBLE);
                Intent intent = new Intent(Choose_Login_And_Reg.this, LoginActivity.class);
                startActivity(intent);
                finish();
                spinner.setVisibility(View.GONE);
                return;
            }
        });

        mRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spinner.setVisibility(View.VISIBLE);
                Intent intent = new Intent(Choose_Login_And_Reg.this, RegisterActivity.class);
                startActivity(intent);
                finish();
                spinner.setVisibility(View.GONE);
                return;
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        return;
    }


}