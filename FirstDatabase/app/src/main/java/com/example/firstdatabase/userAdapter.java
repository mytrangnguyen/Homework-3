package com.example.firstdatabase;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.core.view.LayoutInflaterCompat;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;



public  class  userAdapter extends RecyclerView.Adapter<userAdapter.userViewHolder> {

    List<String> userList = new ArrayList<>();

    @NonNull
    @Override
    public userViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_user_item, parent, false);

        return new userViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull userViewHolder holder, int position) {
        holder.userItem.setText(userList.get(position)+"");

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class userViewHolder extends RecyclerView.ViewHolder{

        TextView userItem;

        public userViewHolder(@NonNull View itemView) {
            super(itemView);
            userItem = itemView.findViewById(R.id.userItem);
        }
    }

}
