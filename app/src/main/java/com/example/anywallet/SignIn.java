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

public class SignIn extends AppCompatActivity {

    EditText et_username,et_password,et_repassword;
    TextView tv_login;
    Button bt_submit;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_sign_in);

        et_username=(EditText) findViewById(R.id.et_username);
        et_password=(EditText) findViewById(R.id.et_password);
        et_repassword=(EditText) findViewById(R.id.et_repassword);
        bt_submit=(Button) findViewById(R.id.bt_submit);
        DB=new DBHelper(this);

        tv_login=(TextView) findViewById(R.id.tv_login);
        tv_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });

        bt_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=et_username.getText().toString();
                String password=et_password.getText().toString();
                String repassword=et_repassword.getText().toString();

                if(username.equals("")||password.equals("")||repassword.equals(""))
                    Toast.makeText(getApplicationContext(),"Please enter all the fields!",Toast.LENGTH_SHORT).show();
                else {
                    if(password.equals(repassword)){
                        Boolean checkuser=DB.checkusername(username);
                        if(checkuser==false){
                            Boolean insert=DB.insertData(username,password);
                            if(insert==true){
                                Toast.makeText(getApplicationContext(),"Registered Successfully!",Toast.LENGTH_SHORT).show();
                                openLogin();
                            } else {
                                Toast.makeText(getApplicationContext(),"Registration Failed!",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(getApplicationContext(),"User already exists! Please Login!",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Password not matching!",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
    public void openLogin(){
        Intent intent=new Intent(this,Login.class);
        startActivity(intent);
    }

}