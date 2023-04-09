package com.example.anywallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class Dashboard2 extends AppCompatActivity {

    String balance;
    TextView tv_bal2;
    Button bt_food,bt_travel,bt_healthcare,bt_others;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dashboard2);

        bt_food=findViewById(R.id.bt_food);
        bt_travel=findViewById(R.id.bt_travel);
        bt_healthcare=findViewById(R.id.bt_healthcare);
        bt_others=findViewById(R.id.bt_others);

        balance=getIntent().getStringExtra("Dashboard2");
        tv_bal2=findViewById(R.id.tv_bal2);
        tv_bal2.setText(balance);

        bt_food.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openfood();
            }
        });
        bt_travel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opentravel();
            }
        });
        bt_healthcare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhealthcare();
            }
        });
        bt_others.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openothers();
            }
        });
    }
    public void openfood(){
        Intent intent=new Intent(this,Food.class);
        startActivity(intent);
    }
    public void opentravel(){
        Intent intent=new Intent(this,Travel.class);
        startActivity(intent);
    }
    public void openhealthcare(){
        Intent intent=new Intent(this,HealthCare.class);
        startActivity(intent);
    }
    public void openothers(){
        Intent intent=new Intent(this,Others.class);
        startActivity(intent);
    }
}