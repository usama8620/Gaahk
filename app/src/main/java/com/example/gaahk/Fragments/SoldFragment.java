package com.example.gaahk.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.gaahk.Activities.Data;
import com.example.gaahk.R;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;


public class SoldFragment extends Fragment {

    private RecyclerView mRecyclerView1;
    private SlimAdapter mSlimAdapter1;

    public SoldFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_sold, container, false);

        mRecyclerView1 = rootView.findViewById(R.id.reciepts_card_recycler);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        mRecyclerView1.setLayoutManager(layoutManager1);
        mRecyclerView1.setItemAnimator(new DefaultItemAnimator());
        ArrayList<Data> arrayList2 = new ArrayList<>();
        arrayList2.add(new Data("8:00 pm", "officialusama", ""));
        arrayList2.add(new Data("8:00 pm", "hamxa.alam", ""));
        arrayList2.add(new Data("8:00 pm", "siddiqui.salman", ""));
        arrayList2.add(new Data("8:00 pm", "uzair.ali", ""));
        arrayList2.add(new Data("8:00 pm", "ali.tareen", ""));


        mSlimAdapter1 = SlimAdapter.create()
                .register(R.layout.reciepts_card_view, new SlimInjector<Data>() {
                    @Override
                    public void onInject(final Data data, IViewInjector injector) {
                        injector.clicked(R.id.reciepts_cardview, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getActivity(), "Card Clicked", Toast.LENGTH_SHORT).show();
                            }
                        });
                        injector.text(R.id.card_text_view5, data.getImage() + "");



                    }
                }).attachTo(mRecyclerView1).updateData(arrayList2);

        return rootView;
    }

}
