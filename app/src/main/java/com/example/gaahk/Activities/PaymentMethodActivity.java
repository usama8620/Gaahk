package com.example.gaahk.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.gaahk.R;

public class PaymentMethodActivity extends AppCompatActivity {

    ImageButton backPayment;
    ImageButton visaImage,masterImage;
    Button saveSettings;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        backPayment=findViewById(R.id.back_payment);
        visaImage=findViewById(R.id.payment_visa_imageview);
        masterImage=findViewById(R.id.payment_master_imageview);
        saveSettings=findViewById(R.id.payment_method_save_button);

        backPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        visaImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(PaymentMethodActivity.this,CardDetailsActivity.class);
                startActivity(i);
            }
        });

        masterImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(PaymentMethodActivity.this,CardDetailsActivity.class);
                startActivity(i);
            }
        });

        saveSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Save Settings", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
