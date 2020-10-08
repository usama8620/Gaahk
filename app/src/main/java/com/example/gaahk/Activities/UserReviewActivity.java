package com.example.gaahk.Activities;

import android.os.Bundle;

import com.example.gaahk.Fragments.ReviewPurchasedFragment;
import com.example.gaahk.Fragments.ReviewSoldFragment;
import com.example.gaahk.Model.TabAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.widget.ImageButton;

import com.example.gaahk.R;
import com.google.android.material.tabs.TabLayout;

public class UserReviewActivity extends AppCompatActivity {

    ViewPager viewPager2;
    TabLayout tabLayout;
    private TabAdapter adapter;
    ImageButton backReviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_review);
        backReviews=findViewById(R.id.back_reviews);

        backReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        viewPager2 = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getSupportFragmentManager());
        adapter.addFragment(new ReviewSoldFragment(), "Sold");
        adapter.addFragment(new ReviewPurchasedFragment(), "Purchased");
        viewPager2.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager2);
//        tabLayout.setTabRippleColor(R.color.colorPrimary);
        tabLayout.setOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
//                tab.set

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }
}