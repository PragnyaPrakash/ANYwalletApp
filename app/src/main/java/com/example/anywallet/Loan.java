package com.example.anywallet;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Loan extends AppCompatActivity {

    EditText et_loanamount,et_rate,et_noyears;
    String l,r,y,intpermonth;
    double loan,rate,years,totalinterest,interestpermonth;
    TextView tv_output;
    Button bt_loan1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_loan);

        et_loanamount=findViewById(R.id.et_loanamount);
        et_rate=findViewById(R.id.et_rate);
        et_noyears=findViewById(R.id.et_noyears);
        tv_output=findViewById(R.id.tv_output);
        bt_loan1=findViewById(R.id.bt_loan1);
        bt_loan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                l=et_loanamount.getText().toString();
                r=et_rate.getText().toString();
                y=et_noyears.getText().toString();
                if(l.equals("")||(r.equals(""))||y.equals("")){
                    tv_output.setText("Please fill all the fields!");
                }
                else {
                    loan = Double.parseDouble(l);
                    rate = Double.parseDouble(r);
                    years = Double.parseDouble(y);
                    totalinterest=(loan*rate*years)/100;
                    interestpermonth=(totalinterest/years)/12;
                    intpermonth=Double.toString(interestpermonth);
                    tv_output.setText("Interest to be paid per month is "+intpermonth);
                }
            }
        });

    }
}