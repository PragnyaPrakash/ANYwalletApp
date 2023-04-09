package com.example.anywallet;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

public class Dashboard1 extends AppCompatActivity {

    String balance;
    TextView tv_balance;
    ImageView img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_dashboard1);
        img=findViewById(R.id.img_trial);
        tv_balance=findViewById(R.id.tv_bal);
        balance=getIntent().getStringExtra("dash1");
        tv_balance.setText(balance);
        tv_balance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDashboard2();
            }
        });

    }
    public void openDashboard2(){
        Intent intent=new Intent(this,Dashboard2.class);
        intent.putExtra("Dashboard2",balance);
        Bundle b=ActivityOptions.makeSceneTransitionAnimation(this,img,"trial").toBundle();
        startActivity(intent,b);
    }
}