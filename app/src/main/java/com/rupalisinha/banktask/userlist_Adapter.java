package com.rupalisinha.banktask;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class userlist_Adapter extends RecyclerView.Adapter<ViewHolder> {

    com.rupalisinha.banktask.UserList UserList;
    List<Model> modelList;
    Context context;

    public userlist_Adapter(com.rupalisinha.banktask.UserList userList, List<Model> modelList) {
        this.UserList = userList;
        this.modelList = modelList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.userslist_row, parent, false);

        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                UserList.nextActivity(position);
            }
        });

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mName.setText(modelList.get(position).getName());
        holder.mPhonenumber.setText(modelList.get(position).getPhoneno());
        holder.mBalance.setText(modelList.get(position).getBalance());
        holder.mAccountNumber.setText(modelList.get(position).getAccountnumber());
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }
}

