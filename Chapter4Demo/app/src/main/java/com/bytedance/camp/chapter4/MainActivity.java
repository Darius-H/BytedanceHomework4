package com.bytedance.camp.chapter4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        handler = new Handler()
        {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                int arg1 = msg.arg1;
                if (msg.what == 1) {
                    if (arg1 == 0) {
                        View clockview=findViewById(R.id.clock);
                        clockview.invalidate();
                    }
                }
            }
        };
        new Thread()
        {
            @Override
            public void run() {
                super.run();
                while(true)
                {
                    try {
                        sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Message msg=new Message();
                    msg.what=1;
                    msg.arg1=0;
                    handler.sendMessage(msg);
                }
            }
        }.start();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
