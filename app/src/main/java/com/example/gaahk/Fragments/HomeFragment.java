package com.example.gaahk.Fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.gaahk.Activities.CartActivity;
import com.example.gaahk.Activities.CommentActivity;
import com.example.gaahk.Activities.Data;
import com.example.gaahk.Activities.ExploreActivity;
import com.example.gaahk.Activities.LikeActivity;
import com.example.gaahk.Activities.ProductDetailsActivity;
import com.example.gaahk.MainActivity;
import com.example.gaahk.R;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;

import static com.example.gaahk.Activities.LoginActivity.PREFERENCE;



public class HomeFragment extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView mRecyclerView1;

    private SlimAdapter mSlimAdapter;
    private SlimAdapter mSlimAdapter1;
    private SlimAdapter mSlimAdapter2;
    ImageView cartImage;
    ImageView searchImage;

    SharedPreferences mSharedPreferences;
    ProgressBar progressBar;

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home, container, false);
        cartImage = view.findViewById(R.id.cart_imageview);
        searchImage = view.findViewById(R.id.search_imageview);
        progressBar = view.findViewById(R.id.progress);
        mSharedPreferences = getActivity().getSharedPreferences(PREFERENCE, Context.MODE_PRIVATE);


        cartImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), CartActivity.class);
                startActivity(i);
            }
        });

        searchImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), ExploreActivity.class);
                startActivity(i);

            }
        });

        mRecyclerView = view.findViewById(R.id.card_recycler);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
//        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

        final ArrayList<Data> arrayList2 = new ArrayList<>();
        arrayList2.add(new Data("officialusama", "Lahore, Pakistan", ""));
        arrayList2.add(new Data("hamxa.alam", "Karachi, Pakistan", ""));
        arrayList2.add(new Data("siddiqui.salman", "Islamabad, Pakistan", ""));
        arrayList2.add(new Data("haider.ch", "Faislabad, Pakistan", ""));

        mSlimAdapter1 = SlimAdapter.create()
                .register(R.layout.home_card_view, new SlimInjector<Data>() {
                    @Override
                    public void onInject(final Data data, IViewInjector injector) {
                        injector.clicked(R.id.home_cardview, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getActivity(), "Card Clicked", Toast.LENGTH_SHORT).show();
                            }
                        });
                        injector.text(R.id.home_card_text_view1, data.getName() + "");
                        injector.text(R.id.home_card_text_view2, data.getImage() + "");
                    }
                    }).attachTo(mRecyclerView).updateData(arrayList2);


        mRecyclerView1 = view.findViewById(R.id.card_recycler_2);
   //     LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        mRecyclerView1.setLayoutManager(layoutManager1);
        mRecyclerView1.setItemAnimator(new DefaultItemAnimator());


        mSlimAdapter2 = SlimAdapter.create()
                .register(R.layout.home_card_view_2, new SlimInjector<Data>() {
                    @Override
                    public void onInject(final Data data, IViewInjector injector) {
                        injector.clicked(R.id.home_cardview2, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i= new Intent(getActivity(), ProductDetailsActivity.class);
                                startActivity(i);
                            }
                        });

                        injector.clicked(R.id.like_image, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                            Intent i= new Intent(getActivity(), LikeActivity.class);
                            startActivity(i);
                            }
                        });

                        injector.clicked(R.id.comment_image, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Intent i= new Intent(getActivity(), CommentActivity.class);
                                startActivity(i);
                            }
                        });

                        injector.text(R.id.card_text_view1, data.getName() + "");
                        injector.text(R.id.card_text_view2, data.getImage() + "");
                    }
                }).attachTo(mRecyclerView1).updateData(arrayList2);

        return view;
    }
}
