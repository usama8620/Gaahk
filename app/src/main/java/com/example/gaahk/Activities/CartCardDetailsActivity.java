package com.example.gaahk.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaahk.R;

public class CartCardDetailsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] countrySpinner = { "Select Country", "  Pakistan", "  United States", "  United Kingdom"};
    EditText accountNo,paymentExpire,paymentCVV,postCode;
    Button saveButton;
    ImageButton backPayment;
    TextView textview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart_card_details);

        final Spinner spinCountry =  findViewById(R.id.card_country);
        spinCountry.setOnItemSelectedListener(this);

        // Initializing an ArrayAdapter
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,countrySpinner
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinCountry.setAdapter(spinnerArrayAdapter);

        saveButton=findViewById(R.id.cart_card_details_proceed_button);
        accountNo=findViewById(R.id.card_account_no);
        paymentExpire=findViewById(R.id.card_expire);
        paymentCVV=findViewById(R.id.card_cvv);
        postCode=findViewById(R.id.card_postal);
        backPayment=findViewById(R.id.back_payment);

        backPayment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        textview=findViewById(R.id.cart_payment_amount);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(CartCardDetailsActivity.this,CartPaymentActivity.class);
                startActivity(i);
            }
        });



    }

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }


}
