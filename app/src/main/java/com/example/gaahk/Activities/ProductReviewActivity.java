package com.example.gaahk.Activities;

import android.os.Bundle;

import com.example.gaahk.Fragments.ReviewPurchasedFragment;
import com.example.gaahk.Fragments.ReviewSoldFragment;
import com.example.gaahk.Model.TabAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.gaahk.R;
import com.google.android.material.tabs.TabLayout;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;

public class ProductReviewActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView1;
    private SlimAdapter mSlimAdapter1;



    ImageButton backReviews;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_review);

        backReviews=findViewById(R.id.back_reviews);

        backReviews.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mRecyclerView1 = findViewById(R.id.product_review_card_recycler);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getApplicationContext());
        mRecyclerView1.setLayoutManager(layoutManager1);
        mRecyclerView1.setItemAnimator(new DefaultItemAnimator());
        ArrayList<Data> arrayList2 = new ArrayList<>();
        arrayList2.add(new Data("8:00 pm", "officialusama", ""));
        arrayList2.add(new Data("8:00 pm", "hamxa.alam", ""));
        arrayList2.add(new Data("8:00 pm", "siddiqui.salman", ""));
        arrayList2.add(new Data("8:00 pm", "uzair.ali", ""));
        arrayList2.add(new Data("8:00 pm", "ali.tareen", ""));


        mSlimAdapter1 = SlimAdapter.create()
                .register(R.layout.prdouct_user_review_card_view, new SlimInjector<Data>() {
                    @Override
                    public void onInject(final Data data, IViewInjector injector) {
                        injector.clicked(R.id.product_user_cardview, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getApplicationContext(), "Card Clicked", Toast.LENGTH_SHORT).show();
                            }
                        });
                        injector.text(R.id.profile_text_view1, data.getImage() + "");



                    }
                }).attachTo(mRecyclerView1).updateData(arrayList2);



    }
}