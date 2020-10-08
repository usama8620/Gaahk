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

public class WalletActivity extends AppCompatActivity {

    ImageButton backWallet;
    private RecyclerView mRecyclerView1;
    private SlimAdapter mSlimAdapter1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wallet);

        backWallet=findViewById(R.id.back_wallet);
        backWallet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        mRecyclerView1 = findViewById(R.id.wallet_card_recycler);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getApplicationContext());
        mRecyclerView1.setLayoutManager(layoutManager1);
        mRecyclerView1.setItemAnimator(new DefaultItemAnimator());
        ArrayList<Data> arrayList2 = new ArrayList<>();
        arrayList2.add(new Data("officialusama", "Lahore Raiwind", ""));
        arrayList2.add(new Data("siddiqui.salman", "Lahore Raiwind", ""));
        arrayList2.add(new Data("hamxa.alam", "Lahore Raiwind", ""));


        mSlimAdapter1 = SlimAdapter.create()
                .register(R.layout.wallet_card_view, new SlimInjector<Data>() {
                    @Override
                    public void onInject(final Data data, IViewInjector injector) {
                        injector.clicked(R.id.wallet_cardview, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getApplicationContext(), "Card Clicked", Toast.LENGTH_SHORT).show();
                            }
                        });
                        injector.text(R.id.wallet_textview2, data.getName() + "");



                    }
                }).attachTo(mRecyclerView1).updateData(arrayList2);


    }

}
