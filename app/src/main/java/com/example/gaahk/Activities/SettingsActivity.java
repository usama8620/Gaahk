package com.example.gaahk.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gaahk.R;

public class SettingsActivity extends AppCompatActivity {
    ImageButton backSettings;
    TextView editProfile,paymentMethod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        backSettings=findViewById(R.id.back_settings);
        editProfile=findViewById(R.id.settings_textview1);
        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(SettingsActivity.this,EditProfileActivity.class);
                startActivity(i);
            }
        });

        paymentMethod=findViewById(R.id.settings_textview2);
        paymentMethod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(SettingsActivity.this, PaymentMethodActivity.class);
                startActivity(i);
            }
        });



        backSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
