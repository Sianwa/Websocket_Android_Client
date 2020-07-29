package com.example.dsproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolders> {
    private ArrayList<ToyItem> toyItemArrayList;
   CartButtonListener cartButtonListener;

    public RecyclerViewAdapter(ArrayList<ToyItem> toyItemArrayList, CartButtonListener cartButtonListener) {
        this.toyItemArrayList = toyItemArrayList;
        this.cartButtonListener = cartButtonListener;
    }

    @NonNull
    @Override
    public ViewHolders onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.toy_row,parent,false);

        return new ViewHolders(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolders holder, int position) {
        ToyItem toyItem = toyItemArrayList.get(position);
        holder.mtoyName.setText(toyItem.getToyName());
        holder.mtoyDesc.setText(toyItem.getToyDescription());
    }


    @Override
    public int getItemCount() {
        return toyItemArrayList.size();
    }


    //viewholder class
    public class ViewHolders extends RecyclerView.ViewHolder {
        View view;
        TextView mtoyName, mtoyDesc;
        Button mButton;

        public ViewHolders(@NonNull View itemView) {
            super(itemView);
            view = itemView;

            //views;
            mtoyName = view.findViewById(R.id.toyName);
            mtoyDesc = view.findViewById(R.id.toyDescription);
            mButton = view.findViewById(R.id.cart);

            mButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    cartButtonListener.cartbtnClick(v,getAdapterPosition());
                }
            });
        }
    }

    public interface CartButtonListener {
        void cartbtnClick(View v, int position);
    }
}
