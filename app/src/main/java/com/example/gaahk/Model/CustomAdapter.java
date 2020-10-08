package com.example.gaahk.Model;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.gaahk.R;

import java.util.ArrayList;
import com.example.gaahk.Fragments.NegotiationFragment;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<String> names;
    private ArrayList<String> body;

    public CustomAdapter(ArrayList<String> names, ArrayList<String> body) {
        this.names = names;
        this.body= body;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.message_card_view, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textViewName.setText(names.get(position));
        holder.textViewBody.setText(body.get(position));
    }

    @Override
    public int getItemCount()
    {
        return names.size();

    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textViewBody;

        ViewHolder(View itemView) {
            super(itemView);

            textViewName = (TextView) itemView.findViewById(R.id.mess_text_view1);
            textViewBody = (TextView) itemView.findViewById(R.id.mess_text_view2);
        }
    }



    public void filterList(ArrayList<String> filterdNames) {
        this.names = filterdNames;
        notifyDataSetChanged();
    }
}

