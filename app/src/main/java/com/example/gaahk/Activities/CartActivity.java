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
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.gaahk.R;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;

public class CartActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView1;
    private SlimAdapter mSlimAdapter1;
    ImageButton backCart;
    Button checkoutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        backCart=findViewById(R.id.back_cart);
        checkoutButton=findViewById(R.id.cart_checkout_button);

        backCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(CartActivity.this,CartPaymentActivity.class);
                startActivity(i);
            }
        });



        mRecyclerView1 = findViewById(R.id.cart_card_recycler);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getApplicationContext());
        mRecyclerView1.setLayoutManager(layoutManager1);
        mRecyclerView1.setItemAnimator(new DefaultItemAnimator());
        ArrayList<Data> arrayList2 = new ArrayList<>();
        arrayList2.add(new Data("8:00 pm", "Lahore Raiwind", ""));
        arrayList2.add(new Data("8:00 pm", "Lahore Raiwind", ""));
        arrayList2.add(new Data("8:00 pm", "Lahore Raiwind", ""));
        arrayList2.add(new Data("8:00 pm", "Lahore Raiwind", ""));
        arrayList2.add(new Data("8:00 pm", "Lahore Raiwind", ""));
        arrayList2.add(new Data("8:00 pm", "Lahore Raiwind", ""));

        mSlimAdapter1 = SlimAdapter.create()
                .register(R.layout.cart_item_card_view, new SlimInjector<Data>() {
                    @Override
                    public void onInject(final Data data, IViewInjector injector) {
                        injector.clicked(R.id.cart_item_cardview, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getApplicationContext(), "Card Clicked", Toast.LENGTH_SHORT).show();
                            }
                        });
                        injector.text(R.id.card_text_view5, data.getImage() + "");



                    }
                }).attachTo(mRecyclerView1).updateData(arrayList2);




    }

}
