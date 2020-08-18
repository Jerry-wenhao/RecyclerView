package com.xiawenhao.recyclerview;

import android.os.Bundle;


import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;


public class ListActivity extends AppCompatActivity {
    ArrayList<Data> dataList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        ButterKnife.bind(this);
        List<Data> dataList = new ArrayList<>();


        //recyclerView.setAdapter();
    }

}
