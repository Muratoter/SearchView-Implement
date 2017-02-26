package com.muratoter.github.searchview;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Murat on 26.02.2017.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Movies> movies= Collections.emptyList();
    private Activity activity;

    public RecyclerViewAdapter(Activity activity,List<Movies> movies){
        this.movies=movies;
        this.activity=activity;
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView tv_baslik,tv_icerik;
        public MyViewHolder(View view){
            super(view);
            tv_baslik=(TextView)view.findViewById(R.id.tv_baslik);
            tv_icerik=(TextView)view.findViewById(R.id.tv_icerik);
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View myView= LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,parent,false);
        return new MyViewHolder(myView);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder=(MyViewHolder)holder;
        myViewHolder.tv_baslik.setText(movies.get(position).getMoviesName());
        myViewHolder.tv_icerik.setText("\t"+movies.get(position).getMoviesDescription());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public void setFilter(ArrayList<Movies> newList){
        movies=new ArrayList<>();
        movies.addAll(newList);
        notifyDataSetChanged();
    }





}
