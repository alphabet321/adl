package com.example.myapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.widget.TextView;

import com.example.myapplication.R;

public class MainActivity extends Activity {

    private TextView messageText;
    private BroadcastReceiver smsReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        messageText = (TextView) findViewById(R.id.messageText);

        // Register a broadcast receiver to listen for incoming SMS messages
        smsReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                if (intent.getAction().equals(Telephony.Sms.Intents.SMS_RECEIVED_ACTION)) {
                    // Extract the message from the intent
                    String messageBody = "";
                    for (SmsMessage smsMessage : Telephony.Sms.Intents.getMessagesFromIntent(intent)) {
                        messageBody += smsMessage.getMessageBody();
                    }

                    // Display an alert with the message
                    new AlertDialog.Builder(MainActivity.this)
                            .setTitle("New message received")
                            .setMessage(messageBody)
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    // Do nothing
                                }
                            })
                            .show();
                }
            }
        };
        IntentFilter filter = new IntentFilter(Telephony.Sms.Intents.SMS_RECEIVED_ACTION);
        registerReceiver(smsReceiver, filter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(smsReceiver);
    }
}