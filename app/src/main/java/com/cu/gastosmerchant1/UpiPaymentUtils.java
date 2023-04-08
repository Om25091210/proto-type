package com.cu.gastosmerchant1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.cu.gastosmerchant1.Activity.OnBoardingActivity;
import com.cu.gastosmerchant1.Dashboard.Home;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class UpiPaymentUtils extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private final String MyPrefs = "MY_PREFERENCE";
    private final String REG_PAYMENT = "REG_PAYMENT";
    boolean isPaid=false;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sharedPreferences=getSharedPreferences(MyPrefs,MODE_PRIVATE);
        isPaid=sharedPreferences.getBoolean(REG_PAYMENT,false);

        mAuth = FirebaseAuth.getInstance();
        //This method is used so that your splash activity
        //can cover the entire screen.
    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user=mAuth.getCurrentUser();
        if(user!=null){
            Intent intent=new Intent(UpiPaymentUtils.this, Home.class);
            startActivity(intent);
            finish();
        }
        else{
            Intent intent=new Intent(UpiPaymentUtils.this, OnBoardingActivity.class);
            startActivity(intent);
            finish();
        }
    }
}

