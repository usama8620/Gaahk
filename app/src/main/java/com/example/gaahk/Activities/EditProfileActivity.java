package com.example.gaahk.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.gaahk.R;

public class EditProfileActivity extends AppCompatActivity {

    ImageButton uploadEdit,backEdit;
    EditText dukanName,firstName,lastName,phoneNum;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);


        uploadEdit=findViewById(R.id.edit_image_button);
        backEdit=findViewById(R.id.back_edit);

        dukanName=findViewById(R.id.edit_dukan_name);
        firstName=findViewById(R.id.edit_first_name);
        lastName=findViewById(R.id.edit_last_name);
        phoneNum=findViewById(R.id.edit_phone);

        saveButton=findViewById(R.id.edit_profile_save_button);

        backEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        uploadEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Upload Picture", Toast.LENGTH_SHORT).show();
            }
        });

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Save changed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
