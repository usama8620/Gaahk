package com.example.gaahk.Activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gaahk.R;

public class CardDetailsActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String[] countrySpinner = { "Select Country", "  Pakistan", "  United States", "  United Kingdom"};
    EditText accountNo,paymentExpire,paymentCVV,postCode;
    Button saveButton;
    ImageButton backPayment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);
        final Spinner spinCountry =  findViewById(R.id.card_country);
        spinCountry.setOnItemSelectedListener(this);

        // Initializing an ArrayAdapter
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,countrySpinner
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinCountry.setAdapter(spinnerArrayAdapter);

        saveButton=findViewById(R.id.card_details_save_button);
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

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Save Changes", Toast.LENGTH_SHORT).show();
            }
        });

    }


    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }

}
