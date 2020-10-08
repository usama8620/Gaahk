package com.example.gaahk.Fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaahk.Activities.ChatViewActivity;
import com.example.gaahk.Activities.Data;
import com.example.gaahk.MainActivity;
import com.example.gaahk.Model.CustomAdapter;
import com.example.gaahk.R;

import net.idik.lib.slimadapter.SlimAdapter;
import net.idik.lib.slimadapter.SlimInjector;
import net.idik.lib.slimadapter.viewinjector.IViewInjector;

import java.util.ArrayList;

public class NegotiationFragment extends Fragment {

    ImageButton backMess;
    private RecyclerView mRecyclerView1;
    private SlimAdapter mSlimAdapter1;
    ArrayList<String> names;
    ArrayList<String> body;
    EditText searchEditText;
    TextView negotiation;

    CustomAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.fragment_cam, container, false);

        backMess=rootView.findViewById(R.id.back_mess);
        backMess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getActivity(), MainActivity.class);
                startActivity(i);
            }
        });

        negotiation=rootView.findViewById(R.id.negotiation_textview);
        negotiation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i= new Intent(getActivity(), ChatViewActivity.class);
                startActivity(i);
            }
        });

        searchEditText= rootView.findViewById(R.id.message_search_edit_text);

        mRecyclerView1 = rootView.findViewById(R.id.mess_card_recycler);
        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
        mRecyclerView1.setLayoutManager(layoutManager1);
        mRecyclerView1.setItemAnimator(new DefaultItemAnimator());

        names = new ArrayList<>();
        body = new ArrayList<>();

        names.add("Usama");
        body.add("Hello, how are you?");
        names.add("Hamza");
        body.add("what's up?");
        names.add("Salman");
        body.add("let's meet");
        names.add("Umair");
        body.add("you insterested in the product?");
        names.add("Haider");
        body.add("Hello, ping me");
        names.add("Alina");
        body.add("okay fine");
        names.add("Maham");
        body.add("call me if you want to order");






        adapter = new CustomAdapter(names,body);

        mRecyclerView1.setAdapter(adapter);



//
//        LinearLayoutManager layoutManager1 = new LinearLayoutManager(getActivity());
//        mRecyclerView1.setLayoutManager(layoutManager1);
//        mRecyclerView1.setItemAnimator(new DefaultItemAnimator());
//        ArrayList<Data> arrayList2 = new ArrayList<>();
//        arrayList2.add(new Data("officialusama", "Lahore Raiwind", ""));
//        arrayList2.add(new Data("siddiqui.salman", "Lahore Raiwind", ""));
//        arrayList2.add(new Data("hamxa.alam", "Lahore Raiwind", ""));
//
//
//        mSlimAdapter1 = SlimAdapter.create()
//                .register(R.layout.message_card_view, new SlimInjector<Data>() {
//                    @Override
//                    public void onInject(final Data data, IViewInjector injector) {
//                        injector.clicked(R.id.mess_cardview, new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                Toast.makeText(getActivity(), "Card Clicked", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//                        injector.text(R.id.mess_textview1, data.getName() + "");
//
//
//
//                    }
//                }).attachTo(mRecyclerView1).updateData(arrayList2);



        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                //after the change calling the method and passing the search input
                filter(editable.toString());
            }
        });





        // Inflate the layout for this fragment
        return rootView;

    }


    private void filter(String text) {
        //new array list that will hold the filtered data
        ArrayList<String> filterdNames = new ArrayList<>();


        //looping through existing elements
        for (String s : names) {
            //if the existing elements contains the search input
            if (s.toLowerCase().contains(text.toLowerCase())) {
                //adding the element to filtered list
                filterdNames.add(s);
            }
        }



        //calling a method of the adapter class and passing the filtered list
        adapter.filterList(filterdNames);
    }


}
