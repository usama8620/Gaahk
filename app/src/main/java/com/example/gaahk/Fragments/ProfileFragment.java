package com.example.gaahk.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaahk.Activities.ReviewsActivity;
import com.example.gaahk.MainActivity;
import com.example.gaahk.Model.TabAdapter;
import com.example.gaahk.R;
import com.google.android.material.tabs.TabLayout;

import net.idik.lib.slimadapter.SlimAdapter;

public class ProfileFragment extends Fragment {

    RatingBar rb;

    private RecyclerView mRecyclerView1;
    private SlimAdapter mSlimAdapter1;

    ViewPager viewPager2;
    TabLayout tabLayout;
    private TabAdapter adapter;
    ImageButton backStore;

    TextView reviewText1,reviewText2;

    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_profile, container, false);

        rb=rootView.findViewById(R.id.MyRating);

        rb.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener(){

            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating,
                                        boolean fromUser) {
                // TODO Auto-generated method stub
                Toast.makeText(getActivity(),Float.toString(rating), Toast.LENGTH_LONG).show();

            }

        });

        reviewText1=rootView.findViewById(R.id.profile_text_view3);
        reviewText2=rootView.findViewById(R.id.profile_text_view4);

        reviewText1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getActivity(), ReviewsActivity.class);
                startActivity(i);

            }
        });

        reviewText2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getActivity(),ReviewsActivity.class);
                startActivity(i);

            }
        });


        backStore=rootView.findViewById(R.id.back_store);

        backStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }
        });

        viewPager2 = rootView.findViewById(R.id.viewPager);
        tabLayout = rootView.findViewById(R.id.tabLayout);
        adapter = new TabAdapter(getActivity().getSupportFragmentManager());
        adapter.addFragment(new SellingProfileFragment(), "SELLING");
        adapter.addFragment(new SoldProfileFragment(), "SOLD");
        viewPager2.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager2);

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

        return rootView;
    }


}
