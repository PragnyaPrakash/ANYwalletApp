package com.example.anywallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

public class MainPage extends AppCompatActivity {

    String username;
    Button bt_logout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main_page);
        TextView tv_welcome=(TextView) findViewById(R.id.tv_welcome);
        username=getIntent().getStringExtra("Message");
        tv_welcome.setText("Welcome "+username+"!");

        Button bt_arrow=(Button) findViewById(R.id.bt_arrow);
        bt_arrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWelcome();
            }
        });
        bt_logout=findViewById(R.id.bt_logout);
        bt_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
    }
    public void openWelcome(){
        Intent intent=new Intent(this,Welcome.class);
        intent.putExtra("Message2",username);
        startActivity(intent);
    }
    public void openLogin(){
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);
    }
}