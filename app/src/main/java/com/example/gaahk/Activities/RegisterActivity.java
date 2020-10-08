package com.example.gaahk.Activities;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.gaahk.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import static com.example.gaahk.Activities.LoginActivity.PREFERENCE;
import static com.example.gaahk.Activities.LoginActivity.PREF_SKIP_LOGIN;

public class RegisterActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Button RegistrationButton;
    EditText firstName, lastName, userName, email, mobile, password;
    SharedPreferences mSharedPreferences;
    String[] countrySpinner = { "Select Country", "  Pakistan", "  United States", "  United Kingdom"};
    String[] paymentSpinner = { "Select Payment Method", "  Cash On Delivery", "  Union Pay", "  Visa/MasterCard"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        final Spinner spinCountry = (Spinner) findViewById(R.id.reg_country);
        spinCountry.setOnItemSelectedListener(this);

        final Spinner spinPayment = (Spinner) findViewById(R.id.reg_payment);
        spinPayment.setOnItemSelectedListener(this);

        // Initializing an ArrayAdapter
        ArrayAdapter<String> spinnerArrayAdapter = new ArrayAdapter<String>(
                this,R.layout.spinner_item,countrySpinner
        );
        spinnerArrayAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinCountry.setAdapter(spinnerArrayAdapter);

        ArrayAdapter<String> spinnerArrayAdapter2 = new ArrayAdapter<String>(
                this,R.layout.spinner_item,paymentSpinner
        );
        spinnerArrayAdapter2.setDropDownViewResource(R.layout.spinner_item);
        spinPayment.setAdapter(spinnerArrayAdapter2);

        mSharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        final ImageButton imageButton= findViewById(R.id.reg_image_button);
        ImageButton imageButton1= findViewById(R.id.back_register);

        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Please fill all the fields", Toast.LENGTH_SHORT).show();
            }
        });

        imageButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                SharedPreferences.Editor mEditor = mSharedPreferences.edit();
                mEditor.putString(PREF_SKIP_LOGIN, "skip");
                mEditor.commit();
                startActivity(i);
            }
        });





        firstName =  findViewById(R.id.reg_first_name);
        lastName =  findViewById(R.id.reg_last_name);
        userName=findViewById(R.id.reg_username);
        email=findViewById(R.id.reg_email);
        mobile=findViewById(R.id.reg_mobile);
        password=findViewById(R.id.reg_pass);
        RegistrationButton = findViewById(R.id.reg_sign_up_button);


        RegistrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(i);
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl(getResources().getString(R.string.URL))
//                        .addConverterFactory(ScalarsConverterFactory.create())
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//
//                ApiInterface service = retrofit.create(ApiInterface.class);
//                Call<RegisterModel> call = service.register("application/json", firstName.getText().toString(), lastName.getText().toString(),dob.getText().toString(),spin.getSelectedItem().toString(),emailRegistration.getText().toString(),passwordRegistration.getText().toString(),confirmPasswordRegistration.getText().toString());
//                call.enqueue(new Callback<RegisterModel>() {
//                    @Override
//                    public void onResponse(Call<RegisterModel> call, Response<RegisterModel> response) {
//                        //response.body() have your LoginResult fields and methods  (example you have to access error then try like this response.body().getError() )
//                        if (response.isSuccessful()) {
//                            assert response.body() != null;
//                            if (response.body().getError().toString().equalsIgnoreCase("false")) {
//                                Intent i = new Intent(RegisterActivity.this, LoginRegistrationActivity.class);
//                                SharedPreferences.Editor mEditor = mSharedPreferences.edit();
//                                mEditor.putString(PREF_SKIP_LOGIN, "skip");
//                                mEditor.commit();
//                                startActivity(i);
//                            }
//                            else{
//                                Toast.makeText(RegisterActivity.this, ""+ response.body().getMessage(), Toast.LENGTH_SHORT).show();
//                            }
//                        } else {
////                                progressBar.setVisibility(View.GONE);
//                            getWindow().clearFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
//                            BufferedReader reader = null;
//                            StringBuilder sb = new StringBuilder();
//                            assert response.errorBody() != null;
//                            reader = new BufferedReader(new InputStreamReader(response.errorBody().byteStream()));
//                            String line;
//                            try {
//                                while ((line = reader.readLine()) != null) {
//                                    sb.append(line);
//                                }
//                            } catch (IOException e) {
//                                e.printStackTrace();
//                            }
//
//                            String finallyError = sb.toString();
//                            Log.e("TGED", "ERORRRRRRR" + finallyError);
//                            Toast.makeText(RegisterActivity.this, "" + finallyError, Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<RegisterModel> call, Throwable t) {
//
//                        Toast.makeText(RegisterActivity.this, "Response Failure", Toast.LENGTH_SHORT).show();
//                    }
//                });
            }
        });



    }

    //Performing action onItemSelected and onNothing selected

    public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {

    }

    public void onNothingSelected(AdapterView<?> arg0) {
        // TODO Auto-generated method stub
    }



}
