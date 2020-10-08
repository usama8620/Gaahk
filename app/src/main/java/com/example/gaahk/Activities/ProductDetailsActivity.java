package com.example.gaahk.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.example.gaahk.Model.ImageAdapter;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaahk.R;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;

public class ProductDetailsActivity extends AppCompatActivity {

    TextView productReview,userReview;
    ImageView likeImage, commentImage;
    ImageButton backProductDetails;

    private ImageAdapter adapter;
    private RecyclerView mRecyclerView1;
    private SlimAdapter mSlimAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        backProductDetails=findViewById(R.id.back_store);
        backProductDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        likeImage=findViewById(R.id.like_image);

        likeImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), LikeActivity.class);
                startActivity(i);
            }
        });

        commentImage=findViewById(R.id.comment_image);
        commentImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), CommentActivity.class);
                startActivity(i);
            }
        });

        productReview=findViewById(R.id.card_text_view15);

        productReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), ProductReviewActivity.class);
                startActivity(i);
            }
        });

        userReview=findViewById(R.id.card_text_view19);

        userReview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getApplicationContext(), UserReviewActivity.class);
                startActivity(i);
            }
        });

        mRecyclerView1 = findViewById(R.id.product_detail_recycler);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getApplicationContext());
        mRecyclerView1.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
//        mRecyclerView1.setLayoutManager(layoutManager1);
        mRecyclerView1.setItemAnimator(new DefaultItemAnimator());
        ArrayList<Data> arrayList2 = new ArrayList<>();
        arrayList2.add(new Data("8:00 pm", "Pending", ""));
        arrayList2.add(new Data("8:00 pm", "Arrive in 3 Days", ""));
        arrayList2.add(new Data("8:00 pm", "Pick Up Item", ""));
        arrayList2.add(new Data("8:00 pm", "Return in 11 Days", ""));
        arrayList2.add(new Data("8:00 pm", "Return in 13 Days", ""));
        arrayList2.add(new Data("8:00 pm", "Return in 13 Days", ""));
        arrayList2.add(new Data("8:00 pm", "Return in 15 Days", ""));
        arrayList2.add(new Data("8:00 pm", "Return in 20 Days", ""));
        arrayList2.add(new Data("8:00 pm", "Return in 20 Days", ""));
        arrayList2.add(new Data("8:00 pm", "Pending", ""));
        arrayList2.add(new Data("8:00 pm", "Arrive in 3 Days", ""));
        arrayList2.add(new Data("8:00 pm", "Pick Up Item", ""));
        arrayList2.add(new Data("8:00 pm", "Return in 11 Days", ""));
        arrayList2.add(new Data("8:00 pm", "Return in 13 Days", ""));
        arrayList2.add(new Data("8:00 pm", "Return in 13 Days", ""));
        arrayList2.add(new Data("8:00 pm", "Return in 15 Days", ""));
        arrayList2.add(new Data("8:00 pm", "Return in 20 Days", ""));
        arrayList2.add(new Data("8:00 pm", "Return in 20 Days", ""));


        mSlimAdapter1 = SlimAdapter.create()
                .register(R.layout.related_product_card_view, new SlimInjector<Data>() {
                    @Override
                    public void onInject(final Data data, IViewInjector injector) {
                        injector.clicked(R.id.related_product_cardview, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getApplicationContext(),"card clicked", Toast.LENGTH_SHORT).show();
                            }
                        });




                    }
                }).attachTo(mRecyclerView1).updateData(arrayList2);

    }
}