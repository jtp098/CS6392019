package com.example.imageviewer;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;


public class ListFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState){

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        GridView gridView = (GridView) view.findViewById(R.id.listGridView);
        gridView.setAdapter(new MyAdapter(view.getContext()));
        return view;




    }



}
