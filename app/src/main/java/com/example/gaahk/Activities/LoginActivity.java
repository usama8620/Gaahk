package com.example.gaahk.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.example.gaahk.MainActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.gaahk.R;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginActivity extends AppCompatActivity {


    public static final String PREFERENCE = "preference";
    public static final String PREF_USERNAME = "username";
    public static final String PREF_PASSWORD = "username";
    public static final String PREF_TOKEN = "token";
    public static final String PREF_SKIP_LOGIN = "skip_login";
    public static Activity GLOBAL;

    public SharedPreferences mSharedPreferences;
    android.widget.Button loginButton, RegistrationButton;
    EditText useremailLogin, passwordLogin;
    TextView forgetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        useremailLogin = (EditText) findViewById(R.id.login_fragment_email);
        passwordLogin = (EditText) findViewById(R.id.login_fragment_password);
        //viewpager declaration
        forgetPassword = (TextView) findViewById(R.id.tv_forget_pass);
        //button declaration
        loginButton = (Button) findViewById(R.id.login_fragment_login_button);
        TextView registerText  = findViewById(R.id.signup_textview);
        //   viewPager = (ViewPager) getActivity().findViewById(R.id.login_registration_view_pager);

        mSharedPreferences = getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);
        mSharedPreferences.edit().clear();

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
//                Retrofit retrofit = new Retrofit.Builder()
//                        .baseUrl(getResources().getString(R.string.URL))
//                        .addConverterFactory(ScalarsConverterFactory.create())
//                        .addConverterFactory(GsonConverterFactory.create())
//                        .build();
//
//                ApiInterface service = retrofit.create(ApiInterface.class);
//                Call<LoginModel> call = service.login("application/json", useremailLogin.getText().toString(), passwordLogin.getText().toString());
//                call.enqueue(new Callback<LoginModel>() {
//                    @Override
//                    public void onResponse(Call<LoginModel> call, Response<LoginModel> response) {
//                        //response.body() have your LoginResult fields and methods  (example you have to access error then try like this response.body().getError() )
//                        if (response.isSuccessful()) {
//                            assert response.body() != null;
//                            if (response.body().getError().toString().equalsIgnoreCase("false")) {
//                                Intent i = new Intent(LoginRegistrationActivity.this, MainActivity.class);
//                                SharedPreferences.Editor mEditor = mSharedPreferences.edit();
//                                mEditor.putString(PREF_SKIP_LOGIN, "skip");
//                                mEditor.commit();
//                                startActivity(i);
//                            }
//                            else{
//                                Toast.makeText(LoginRegistrationActivity.this, ""+ response.body().getMessage(), Toast.LENGTH_SHORT).show();
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
//                            Toast.makeText(LoginRegistrationActivity.this, "" + finallyError, Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(Call<LoginModel> call, Throwable t) {
//
//                        Toast.makeText(LoginRegistrationActivity.this, "Response Failure", Toast.LENGTH_SHORT).show();
//                    }
//                });
            }
        });

        forgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, ForgetPasswordActivity.class);
                SharedPreferences.Editor mEditor = mSharedPreferences.edit();
                mEditor.putString(PREF_SKIP_LOGIN, "skip");
                mEditor.commit();
                startActivity(i);
            }
        });

        registerText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, RegisterActivity.class);
                SharedPreferences.Editor mEditor = mSharedPreferences.edit();
                mEditor.putString(PREF_SKIP_LOGIN, "skip");
                mEditor.commit();
                startActivity(i);
            }
        });


        //varibale declaration
        /*viewPager = (ViewPager) findViewById(R.id.login_registration_view_pager);
        setupViewPager(viewPager);
        viewPager = (ViewPager) findViewById(R.id.login_registration_view_pager);
        setupViewPager(viewPager);*/


    }

    public class Data {

        @SerializedName("first_name")
        @Expose
        private String firstName;
        @SerializedName("last_name")
        @Expose
        private String lastName;
        @SerializedName("username")
        @Expose
        private String username;
        @SerializedName("dob")
        @Expose
        private String dob;
        @SerializedName("gender")
        @Expose
        private String gender;
        @SerializedName("email")
        @Expose
        private String email;
        @SerializedName("avatar_url")
        @Expose
        private Object avatarUrl;
        @SerializedName("status")
        @Expose
        private String status;
        @SerializedName("api_token")
        @Expose
        private String apiToken;

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getDob() {
            return dob;
        }

        public void setDob(String dob) {
            this.dob = dob;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            this.gender = gender;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public Object getAvatarUrl() {
            return avatarUrl;
        }

        public void setAvatarUrl(Object avatarUrl) {
            this.avatarUrl = avatarUrl;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getApiToken() {
            return apiToken;
        }

        public void setApiToken(String apiToken) {
            this.apiToken = apiToken;
        }

    }

    public class LoginModel {

        @SerializedName("error")
        @Expose
        private Boolean error;
        @SerializedName("message")
        @Expose
        private String message;
        @SerializedName("pending_for_email")
        @Expose
        private Boolean pendingForEmail;
        @SerializedName("account_blocked")
        @Expose
        private Boolean accountBlocked;
        @SerializedName("data")
        @Expose
        private Data data;

        public Boolean getError() {
            return error;
        }

        public void setError(Boolean error) {
            this.error = error;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Boolean getPendingForEmail() {
            return pendingForEmail;
        }

        public void setPendingForEmail(Boolean pendingForEmail) {
            this.pendingForEmail = pendingForEmail;
        }

        public Boolean getAccountBlocked() {
            return accountBlocked;
        }

        public void setAccountBlocked(Boolean accountBlocked) {
            this.accountBlocked = accountBlocked;
        }

        public Data getData() {
            return data;
        }

        public void setData(Data data) {
            this.data = data;
        }

    }

}
