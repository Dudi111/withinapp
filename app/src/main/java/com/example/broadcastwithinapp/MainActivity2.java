package com.example.broadcastwithinapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    private TextView tvmsg;
    private LocalReceiver localReceiver;
    private LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        localBroadcastManager=LocalBroadcastManager.getInstance(this);
        tvmsg=findViewById(R.id.tvmassage);
        registerLocalreceiver();

    }
    private void registerLocalreceiver(){
        localReceiver=new LocalReceiver();
        IntentFilter intentFilter=new IntentFilter("Broadcast");
        localBroadcastManager.registerReceiver(localReceiver,intentFilter);
    }

    private class LocalReceiver extends BroadcastReceiver {


        @Override
        public void onReceive(Context context, Intent intent) {
            if(intent !=null){
                String data=intent.getStringExtra("Key");

                tvmsg.setText(data);

            }

        }
    }
}