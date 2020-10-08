package com.example.gaahk.Activities;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.gaahk.R;

import org.w3c.dom.Text;

public class AboutAppActivity extends AppCompatActivity {

    ImageButton backAbout;
    TextView textAbout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_app);
        backAbout=findViewById(R.id.back_about_app);
        textAbout=findViewById(R.id.about_app_text_view);

        backAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

}
