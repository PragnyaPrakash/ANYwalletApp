package com.example.anywallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BalancePage extends AppCompatActivity {

    TextView tv_balance;
    Button bt_spent,bt_saved,bt_more,bt_logout;;
    String balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_balance_page);
        bt_spent=findViewById(R.id.bt_spent);
        bt_saved=findViewById(R.id.bt_saved);
        bt_more=findViewById(R.id.bt_more);
        tv_balance=findViewById(R.id.tv_balance);
        balance=getIntent().getStringExtra("Message3");
        tv_balance.setText(balance);
        bt_spent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openspent();
            }
        });
        bt_saved.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensaved();
            }
        });
        bt_more.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openMorePage();
            }
        });
        bt_logout=findViewById(R.id.bt_logout2);
        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
    }
    public void openMorePage(){
        Intent intent=new Intent(this,MorePage.class);
        intent.putExtra("more",balance);
        startActivity(intent);
    }
    public void openspent(){
        Intent intent=new Intent(this,Spent.class);
        intent.putExtra("spent",balance);
        startActivity(intent);
    }
    public void opensaved(){
        Intent intent=new Intent(this,Saved.class);
        intent.putExtra("saved",balance);
        startActivity(intent);
    }
    public void openLogin(){
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);
    }
}