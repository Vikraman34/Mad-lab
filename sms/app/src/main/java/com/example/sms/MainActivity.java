package com.example.sms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.Manifest.permission.READ_PHONE_STATE;
import static android.Manifest.permission.READ_SMS;
import static android.Manifest.permission.RECEIVE_SMS;
import static android.Manifest.permission.SEND_SMS;
public class MainActivity extends AppCompatActivity {
    EditText contact_no,user_message;
    Button send;
    TextView msgs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(MainActivity.this,new
                String[]{READ_SMS,RECEIVE_SMS,SEND_SMS,READ_PHONE_STATE},1);
        contact_no = findViewById(R.id.contact_number);
        user_message = findViewById(R.id.user_message);
        send = findViewById(R.id.sendButton);

//        intentFilter = new IntentFilter();
//        intentFilter.addAction("SMS_RECEIVED_ACTION");
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMsg(contact_no.getText().toString(), user_message.getText().toString());
            }
        });

    }
//    void sendMsg(String num,String myMsg) {
//        String SENT = "Message Sent";
//        String DELIVERED = "Message Delivered";
////        PendingIntent sentPI = PendingIntent.getBroadcast(this, 0, new Intent(SENT), 0);
////        PendingIntent deliveredPI = PendingIntent.getBroadcast(this,0,new Intent(DELIVERED),0);
//        SmsManager smsManager = SmsManager.getDefault();
////        smsManager.sendTextMessage(num,null,myMsg,sentPI,deliveredPI);
//        smsManager.sendTextMessage(num,null,myMsg,null,null);
//
//    }

    void sendMsg(String number, String message)
    {
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(number, null, message, null, null);
    }
//    public void nextPage(View view) {
//        Intent intent = new Intent(this, ShapesActivity.class);
//        startActivity(intent);
//
//    }
//    @Override
//    protected void onPause() {
//        unregisterReceiver(intentReceiver);
//        super.onPause();
//    }
//    @Override
//    protected void onResume() {
//        registerReceiver(intentReceiver,intentFilter);
//        super.onResume();
//    }
}


/*
    First in the manifest file - declare user permissions for all the files
    <uses-permission android:name = "android.permission.READ_SMS"/>
     Similarly do the same for                          RECEIVE_SMS, SEND_SMS, READ_PHONE_SMS

     In onCreate request for permissions
     ActivityCompat
 */