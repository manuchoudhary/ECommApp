package com.io.manishchoudhary.ecommapp.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.io.manishchoudhary.ecommapp.Item;
import com.io.manishchoudhary.ecommapp.ItemAdapter;
import com.io.manishchoudhary.ecommapp.R;
import com.io.manishchoudhary.ecommapp.Utils;

import java.util.ArrayList;
import java.util.List;


public class CategoryFragment extends Fragment {

    private RecyclerView listView;
    private ItemAdapter listAdapter;
    private List<Item> itemList;
    private String category;

    public CategoryFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public CategoryFragment(String category) {
        this.category = category;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_category, container, false);

        listView = (RecyclerView) rootView.findViewById(R.id.list);
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //listView.setLayoutManager(new GridLayoutManager(getActivity(), 2));

        itemList = new ArrayList<Item>();

        itemList = Utils.loadItems(this.getActivity().getApplicationContext(), category);

        listAdapter = new ItemAdapter(getActivity(), itemList);
        listView.setAdapter(listAdapter);
        listAdapter.notifyDataSetChanged();

        return rootView;
    }

}
