package com.example.anywallet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_history);

        listView=findViewById(R.id.ListView);
        ArrayList<List> arrayList=new ArrayList<>();
        arrayList.add(new List(R.drawable.swiggy,"890","-"));
        arrayList.add(new List(R.drawable.paypal,"90","+"));
        arrayList.add(new List(R.drawable.emirates,"85900","-"));
        arrayList.add(new List(R.drawable.medplus,"124","-"));
        arrayList.add(new List(R.drawable.bigbasket,"1200","-"));
        arrayList.add(new List(R.drawable.hdfcbank,"2500","+"));
        arrayList.add(new List(R.drawable.googlepay,"10","+"));
        arrayList.add(new List(R.drawable.amazon,"706","-"));
        ListViewAdapter listViewAdapter=new ListViewAdapter(this,R.layout.list_row,arrayList);
        listView.setAdapter(listViewAdapter);
    }
}