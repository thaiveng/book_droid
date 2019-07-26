package com.thaiveng.bookdroid.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.thaiveng.bookdroid.R;
import com.thaiveng.bookdroid.model.BookModel;

import java.util.ArrayList;

public class BookChildAdapter extends RecyclerView.Adapter<BookChildAdapter.MyViewHolder>{

    private ArrayList<BookModel> arrayList;
    private LayoutInflater inflater;

    public BookChildAdapter(Context context, ArrayList<BookModel> arrayList) {
        inflater = LayoutInflater.from(context);
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = inflater.inflate(R.layout.item_book, viewGroup, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        MyViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}
