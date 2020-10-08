package com.example.gaahk.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.badge.BadgeUtils;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.gaahk.R;

public class ResetPasswordActivity extends AppCompatActivity {

    EditText newPass,confirmPass;
    Button resetSubmit;
    ImageButton resetBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        newPass=findViewById(R.id.reset_new_pass);
        confirmPass=findViewById(R.id.reset_confirm_pass);

        resetSubmit=findViewById(R.id.reset_button);
        resetBack=findViewById(R.id.reset_back_button);

        resetBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        resetSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(ResetPasswordActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

    }

}
