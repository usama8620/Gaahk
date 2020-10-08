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
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaahk.R;

public class CartPaymentActivity extends AppCompatActivity {

    ImageButton backCartPayment;
    Button proceed;

    ImageView visaPayment,masterPayment;
    TextView textView1,textView2,textView3,textView4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_payment);

        backCartPayment=findViewById(R.id.back_cart_payment);

        backCartPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        visaPayment=findViewById(R.id.cart_payment_visa_imageview);
        masterPayment=findViewById(R.id.cart_payment_master_imageview);

        visaPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CartPaymentActivity.this, CartCardDetailsActivity.class);
                startActivity(i);
            }
        });

        masterPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(CartPaymentActivity.this, CartCardDetailsActivity.class);
                startActivity(i);
            }
        });

        textView1=findViewById(R.id.jazz_textview1);
        textView2=findViewById(R.id.easypaisa_textview1);
        textView3=findViewById(R.id.hbl_textview1);


        textView4=findViewById(R.id.cart_payment_amount);

        proceed=findViewById(R.id.cart_payment_method_proceed_button);

        proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(CartPaymentActivity.this,OrderTrackingActivity.class);
                startActivity(i);

            }
        });





    }

}
