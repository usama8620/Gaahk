package com.example.gaahk.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.gaahk.Activities.Data;
import com.example.gaahk.MainActivity;
import com.example.gaahk.R;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;

public class AlertFragment extends Fragment {

    ImageButton backAlert;
    private RecyclerView mRecyclerView1;
    private SlimAdapter mSlimAdapter1;

    public AlertFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        View rootView = inflater.inflate(R.layout.fragment_alert, container, false);

        backAlert=rootView.findViewById(R.id.back_alert);
        backAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }
        });

        mRecyclerView1 = rootView.findViewById(R.id.alert_card_recycler);

        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        mRecyclerView1.setLayoutManager(layoutManager1);
        mRecyclerView1.setItemAnimator(new DefaultItemAnimator());
        ArrayList<Data> arrayList2 = new ArrayList<>();
        arrayList2.add(new Data("officialusama", "Lahore Raiwind", ""));
        arrayList2.add(new Data("siddiqui.salman", "Lahore Raiwind", ""));
        arrayList2.add(new Data("hamxa.alam", "Lahore Raiwind", ""));


        mSlimAdapter1 = SlimAdapter.create()
                .register(R.layout.alert_card_view, new SlimInjector<Data>() {
                    @Override
                    public void onInject(final Data data, IViewInjector injector) {
                        injector.clicked(R.id.alert_cardview, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getActivity(), "Card Clicked", Toast.LENGTH_SHORT).show();
                            }
                        });
                        injector.text(R.id.alert_text_view1, data.getName() + "");



                    }
                }).attachTo(mRecyclerView1).updateData(arrayList2);





        // Inflate the layout for this fragment
        return rootView;
    }


}
