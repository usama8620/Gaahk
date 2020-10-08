package com.example.gaahk.Activities;

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
import android.widget.Toast;

import com.example.gaahk.R;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;

public class OrderTrackingActivity extends AppCompatActivity {

    ImageButton backOrder;
    private RecyclerView mRecyclerView1;
    private SlimAdapter mSlimAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_tracking);

        backOrder=findViewById(R.id.back_order);
        backOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mRecyclerView1 = findViewById(R.id.order_tracking_card_recycler);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getApplicationContext());
        mRecyclerView1.setLayoutManager(layoutManager1);
        mRecyclerView1.setItemAnimator(new DefaultItemAnimator());
        ArrayList<Data> arrayList2 = new ArrayList<>();
        arrayList2.add(new Data("Item 1", "Lahore Raiwind", ""));
        arrayList2.add(new Data("Item 2", "Lahore Raiwind", ""));
        arrayList2.add(new Data("Item 3", "Lahore Raiwind", ""));
        arrayList2.add(new Data("Item 4", "Lahore Raiwind", ""));
        arrayList2.add(new Data("Item 5", "Lahore Raiwind", ""));
        arrayList2.add(new Data("Item 6", "Lahore Raiwind", ""));
        arrayList2.add(new Data("Item 7", "Lahore Raiwind", ""));


        mSlimAdapter1 = SlimAdapter.create()
                .register(R.layout.order_tracking_card_view, new SlimInjector<Data>() {
                    @Override
                    public void onInject(final Data data, IViewInjector injector) {
                        injector.clicked(R.id.order_tracking_cardview, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getApplicationContext(), "Card Clicked", Toast.LENGTH_SHORT).show();
                            }
                        });
                        injector.text(R.id.card_text_view, data.getName() + "");



                    }
                }).attachTo(mRecyclerView1).updateData(arrayList2);




    }

}
