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

public class Welcome extends AppCompatActivity {
    EditText et_balance;
    String username,balance;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_welcome);
        TextView tv_welcome=(TextView) findViewById(R.id.tv_welcome2);
        username=getIntent().getStringExtra("Message2");
        tv_welcome.setText("Welcome "+username+"!");
        et_balance=findViewById(R.id.et_balance);

        Button bt_ok=findViewById(R.id.bt_ok);
        bt_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                balance=et_balance.getText().toString();
                if(balance.equals(""))
                    Toast.makeText(getApplicationContext(), "Please give the balance amount!", Toast.LENGTH_SHORT).show();
                else
                    openBalancepage();
            }
        });
    }
    public void openBalancepage(){
        Intent intent=new Intent(this,BalancePage.class);
        intent.putExtra("Message2",username);
        intent.putExtra("Message3",balance);
        startActivity(intent);
    }
}