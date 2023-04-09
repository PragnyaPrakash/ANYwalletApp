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

public class Login extends AppCompatActivity {

    EditText et_username2,et_password2;
    Button bt_login2;
    TextView tv_signup;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        et_username2=(EditText) findViewById(R.id.et_username2);
        et_password2=(EditText) findViewById(R.id.et_password2);
        DB=new DBHelper(this);

        tv_signup=(TextView) findViewById(R.id.tv_signup);
        tv_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSignUp();
            }
        });

        bt_login2=(Button) findViewById(R.id.bt_login2);
        bt_login2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=et_username2.getText().toString();
                String password=et_password2.getText().toString();

                if(username.equals("")||password.equals(""))
                    Toast.makeText(getApplicationContext(),"Please enter all the fields!",Toast.LENGTH_SHORT).show();
                else {
                    Boolean checkuser=DB.checkusernamepassword(username,password);
                    if(checkuser==true){
                        Toast.makeText(getApplicationContext(),"Login successful!",Toast.LENGTH_SHORT).show();
                        openMainPage();
                    } else {
                        Toast.makeText(getApplicationContext(),"Invalid credentials!",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });
    }
    public void openSignUp(){
        Intent intent=new Intent(this,SignIn.class);
        startActivity(intent);
    }
    public void openMainPage(){
        Intent intent=new Intent(this,MainPage.class);
        EditText et_username2=(EditText) findViewById(R.id.et_username2);
        String username=et_username2.getText().toString();
        intent.putExtra("Message",username);
        startActivity(intent);
    }
}