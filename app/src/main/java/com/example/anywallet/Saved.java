package com.example.anywallet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import java.util.ArrayList;

public class Saved extends AppCompatActivity {

    String balance,amount;
    EditText et_check;
    int bal,am;
    Button bt_ok1;
    TextInputLayout tilcompany;
    AutoCompleteTextView actvcompany;
    ArrayList<String> arrayList_company;
    ArrayAdapter<String> arrayAdapter_company;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_saved);
        et_check=findViewById(R.id.et_check2);
        bt_ok1=findViewById(R.id.bt_ok2);
        tilcompany=findViewById(R.id.til_company2);
        actvcompany=findViewById(R.id.actv_company2);
        arrayList_company=new ArrayList<>();
        arrayList_company.add("GooglePay");
        arrayList_company.add("HDFCbank");
        arrayList_company.add("PayPal");
        arrayAdapter_company=new ArrayAdapter<>(getApplicationContext(),R.layout.dropdown_item,arrayList_company);
        actvcompany.setAdapter(arrayAdapter_company);
        actvcompany.setThreshold(1);
        balance=getIntent().getStringExtra("saved");
        bal=Integer.parseInt(balance);
        bt_ok1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                amount=et_check.getText().toString();
                if(amount.equals("")){
                    Toast.makeText(getApplicationContext(), "Please fill the amount!", Toast.LENGTH_SHORT).show();
                } else {
                    am=Integer.parseInt(amount);
                    bal=bal+am;
                    Toast.makeText(getApplicationContext(),"Success!!",Toast.LENGTH_SHORT).show();
                    openBalance(bal);
                }
            }
        });
    }
    public void openBalance(int bal){
        Intent intent=new Intent(this,BalancePage.class);
        balance=Integer.toString(bal);
        intent.putExtra("Message3",balance);
        startActivity(intent);
    }
}