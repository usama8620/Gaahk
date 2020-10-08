package com.example.gaahk.Activities;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaahk.R;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;

public class SelectCoverActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    ImageButton backCover;
    TextView textview;
    private SlimAdapter mSlimAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_cover);

        backCover=findViewById(R.id.back_cover);

        backCover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        textview=findViewById(R.id.cover_next);

        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), AddPicturesActivity.class);
                startActivity(i);
            }
        });


        mRecyclerView = findViewById(R.id.card_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.HORIZONTAL, false);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        final ArrayList<Data> arrayList2 = new ArrayList<>();
        arrayList2.add(new Data("officialusama", "Lahore, Pakistan", ""));
        arrayList2.add(new Data("hamxa.alam", "Karachi, Pakistan", ""));
        arrayList2.add(new Data("siddiqui.salman", "Islamabad, Pakistan", ""));
        arrayList2.add(new Data("haider.ch", "Faislabad, Pakistan", ""));

        mSlimAdapter1 = SlimAdapter.create()
                .register(R.layout.cover_card_view, new SlimInjector<Data>() {
                    @Override
                    public void onInject(final Data data, IViewInjector injector) {
                        injector.clicked(R.id.cover_cardview, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getApplicationContext(), "Card Clicked", Toast.LENGTH_SHORT).show();
                            }
                        });

                    }
                }).attachTo(mRecyclerView).updateData(arrayList2);


    }

}
