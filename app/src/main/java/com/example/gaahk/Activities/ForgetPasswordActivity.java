package com.example.gaahk.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.gaahk.R;

import static com.example.gaahk.Activities.LoginActivity.PREFERENCE;

public class ForgetPasswordActivity extends AppCompatActivity {

    public SharedPreferences mSharedPreferences;
    android.widget.Button forgetButton;
    EditText useremailForget;
    TextView clickHere;
    LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget_password);

        useremailForget = (EditText) findViewById(R.id.reg_email);
        clickHere = (TextView) findViewById(R.id.click_here_text);
        //button declaration
        forgetButton = (Button) findViewById(R.id.forget_button);
        ImageButton imageButton1= findViewById(R.id.forgot_back_button);
        mSharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);

        forgetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(ForgetPasswordActivity.this, ConfirmEmailActivity.class);
                startActivity(i);
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });




    }

}
