package com.arbaz.evinix.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.arbaz.evinix.R;
import com.arbaz.evinix.models.news_model;

import java.util.ArrayList;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.myviewholder> {

    ArrayList<news_model> newsholder;

    public NewsAdapter(ArrayList<news_model> newsholder) {
        this.newsholder = newsholder;
    }

    @NonNull
    @Override
    public myviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_sample,parent,false);
        return new myviewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewholder holder, int position) {
        holder.img.setImageResource(newsholder.get(position).getImage());
        holder.header.setText(newsholder.get(position).getHeader());
        holder.desc.setText(newsholder.get(position).getDesc());
        holder.country.setText(newsholder.get(position).getCountry());
        holder.time.setText(newsholder.get(position).getTime());

    }

    @Override
    public int getItemCount() {
        return newsholder.size();
    }

    class myviewholder extends RecyclerView.ViewHolder{
        ImageView img;
        TextView header,desc,time,country;

        public myviewholder(@NonNull View itemView) {
            super(itemView);
            img = itemView.findViewById(R.id.image);
            header = itemView.findViewById(R.id.header);
            desc= itemView.findViewById(R.id.desc);
            time = itemView.findViewById(R.id.time);
            country = itemView.findViewById(R.id.country);
        }
    }
}
