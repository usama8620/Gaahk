package com.example.gaahk.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.gaahk.Activities.CartCardDetailsActivity;
import com.example.gaahk.Activities.CartPaymentActivity;
import com.example.gaahk.Activities.FeatureActivity;
import com.example.gaahk.Activities.SelectCoverActivity;
import com.example.gaahk.MainActivity;
import com.example.gaahk.R;


public class PostFragment extends Fragment {


    EditText title, category, brand, condition, price, quantity,size,description;

    ImageButton backPost, feature;
    TextView textview;


    public PostFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_post, container, false);

        textview=rootView.findViewById(R.id.post_next);

        textview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getActivity(), SelectCoverActivity.class);
                startActivity(i);

            }
        });

        backPost= rootView.findViewById(R.id.back_post);

        backPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }
        });

        title = rootView.findViewById(R.id.product_title);
        category = rootView.findViewById(R.id.product_category);
        condition = rootView.findViewById(R.id.product_condition);
        price = rootView.findViewById(R.id.product_price);
        brand = rootView.findViewById(R.id.product_brand);
        quantity = rootView.findViewById(R.id.product_quantity);
        size = rootView.findViewById(R.id.product_size);
        description = rootView.findViewById(R.id.product_description);


        feature=rootView.findViewById(R.id.product_feature);

        feature.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getActivity(), FeatureActivity.class);
                startActivity(i);
            }
        });
        
        return rootView;
    }
    



}
