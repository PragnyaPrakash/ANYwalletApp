package com.example.anywallet;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SendSMS extends AppCompatActivity {

    EditText et_Phone,et_Message;
    Button bt_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_send_sms);

        et_Phone=findViewById(R.id.et_phone);
        et_Message=findViewById(R.id.et_message);
        bt_send=findViewById(R.id.bt_send);

        bt_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ContextCompat.checkSelfPermission(SendSMS.this, Manifest.permission.SEND_SMS)== PackageManager.PERMISSION_GRANTED){
                    sendMessage();
                } else {
                    ActivityCompat.requestPermissions(SendSMS.this,new String[]{Manifest.permission.SEND_SMS},100);
                }
            }
        });
    }
    public void sendMessage(){
        String phone=et_Phone.getText().toString().trim();
        String message=et_Message.getText().toString().trim();
        if(!phone.equals("")&&!message.equals("")){
            SmsManager smsManager=SmsManager.getDefault();
            smsManager.sendTextMessage(phone,null,message,null,null);
            Toast.makeText(getApplicationContext(), "SMS sent successfully!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(getApplicationContext(), "Please fill all the fields!", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if(requestCode==100 && grantResults.length>0 && grantResults[0]==PackageManager.PERMISSION_GRANTED){
            sendMessage();
        } else {
            Toast.makeText(getApplicationContext(),"Permission Denied!",Toast.LENGTH_SHORT).show();
        }
    }
}