package com.example.gaahk.Fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
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

public class SellersFragment extends Fragment {

    private RecyclerView mRecyclerView1;
    private SlimAdapter mSlimAdapter1;

    public SellersFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_sellers, container, false);


        mRecyclerView1 = rootView.findViewById(R.id.sellers_card_recycler);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
     //   mRecyclerView1.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        mRecyclerView1.setLayoutManager(layoutManager1);
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
                .register(R.layout.sellers_card_view, new SlimInjector<Data>() {
                    @Override
                    public void onInject(final Data data, IViewInjector injector) {
                        injector.clicked(R.id.imgcardview, new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(getActivity(),"card clicked", Toast.LENGTH_SHORT).show();
                            }
                        });




                    }
                }).attachTo(mRecyclerView1).updateData(arrayList2);
        // Inflate the layout for this fragment
        return rootView;
    }


}
