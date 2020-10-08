package com.example.gaahk.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.example.gaahk.R;

public class ConfirmEmailActivity extends AppCompatActivity {

    Button confirmButton;
    ImageButton backConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_email);


        backConfirm=findViewById(R.id.confirm_back_button);
        confirmButton=findViewById(R.id.confirm_email_button);

        backConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        confirmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(ConfirmEmailActivity.this, ResetPasswordActivity.class);
                startActivity(i);
            }
        });

    }

}
