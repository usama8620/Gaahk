package com.example.gaahk.Activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaahk.R;

public class FeatureActivity extends AppCompatActivity {

    SeekBar seekBar;
    ImageButton backFeature,selectProductImage;
    TextView editProfile;
    LinearLayout selectProduct;
    Button featureButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feature);

        selectProduct=findViewById(R.id.select_product);
        selectProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(FeatureActivity.this, SelectProductActivity.class);
                startActivity(i);
            }
        });

        selectProductImage=findViewById(R.id.select_product_arrow);
        selectProductImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(FeatureActivity.this, SelectProductActivity.class);
                startActivity(i);
            }
        });

        editProfile=findViewById(R.id.feature_textview1);

        editProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(FeatureActivity.this, EditProfileActivity.class);
                startActivity(i);
            }
        });

        backFeature=findViewById(R.id.back_feature);

        backFeature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        featureButton=findViewById(R.id.feature_button);

        featureButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"Feature Button", Toast.LENGTH_SHORT).show();
            }
        });

        seekBar=findViewById(R.id.seekBar);

        seekBar.getProgressDrawable().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
        seekBar.getThumb().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
    }

}
