package com.example.anywallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class MorePage extends AppCompatActivity {

    Button bt_dashboard,bt_history,bt_invite,bt_loan;
    String balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_more_page);
        balance=getIntent().getStringExtra("more");
        bt_dashboard=findViewById(R.id.bt_dashboard);
        bt_history=findViewById(R.id.bt_history);
        bt_invite=findViewById(R.id.bt_invite);
        bt_loan=findViewById(R.id.bt_loan);

        bt_invite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opensendsms();
            }
        });

        bt_dashboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                opendashboard1();
            }
        });
        bt_history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openhistory();
            }
        });
        bt_loan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLoan();
            }
        });
    }
    public void opensendsms(){
        Intent intent=new Intent(this,SendSMS.class);
        startActivity(intent);
    }
    public void opendashboard1(){
        Intent intent=new Intent(this,Dashboard1.class);
        intent.putExtra("dash1",balance);
        startActivity(intent);
    }
    public void openhistory(){
        Intent intent=new Intent(this,History.class);
        startActivity(intent);
    }
    public void openLoan(){
        Intent intent=new Intent(this,Loan.class);
        startActivity(intent);
    }
}