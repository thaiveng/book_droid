package com.thaiveng.bookdroid.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.thaiveng.bookdroid.R;
import com.thaiveng.bookdroid.adapter.BookChildAdapter;
import com.thaiveng.bookdroid.model.BookModel;

import java.util.ArrayList;

public class Book_child_fragment extends Fragment {
    private static final String ARGUMENT_POSITION = "argument_position";
    private ArrayList<BookModel> arrayList;

    public static Book_child_fragment newInstance(int position) {
        Bundle args = new Bundle();
        args.putInt(ARGUMENT_POSITION, position);
        Book_child_fragment fragment = new Book_child_fragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        arrayList = setArray();
    }

    private ArrayList<BookModel> setArray(){
        ArrayList<BookModel> list = new ArrayList<>();
        for (int i=0;i<20;i++){
            BookModel bookModel = new BookModel();
            bookModel.setBook("Book "+i);
            list.add(bookModel);
        }
        return list;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_book_child, container, false);
        RecyclerView recyclerView_reco = view.findViewById(R.id.recycler_book_reco);
        RecyclerView recyclerView_trend = view.findViewById(R.id.recycler_book_trending);

        BookChildAdapter adapter_reco = new BookChildAdapter(getContext(), arrayList);
        recyclerView_reco.setAdapter(adapter_reco);
        BookChildAdapter adapter_trend = new BookChildAdapter(getContext(), arrayList);
        recyclerView_trend.setAdapter(adapter_trend);
        recyclerView_reco.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));
        recyclerView_trend.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL,false));

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}
