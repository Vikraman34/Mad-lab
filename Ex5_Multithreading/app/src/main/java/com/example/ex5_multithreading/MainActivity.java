package com.example.ex5_multithreading;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

public class MainActivity extends AppCompatActivity {
    ProgressBar pbar;
    Handler handler;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt_sleep=findViewById(R.id.bt_sleep);
        final Button bt_start=findViewById((R.id.bt_start));
        pbar=findViewById(R.id.pbar);
        handler=new Handler();
        bt_sleep.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final ProgressDialog pd=new ProgressDialog(MainActivity.this);
                pd.setTitle("Sleep in progress!");
                pd.setMessage("Started!");
                pd.show();
                EditText et_time=findViewById(R.id.et_time);
                int count=Integer.parseInt(et_time.getEditableText().toString());
                new Handler().postDelayed(new Runnable(){
                    @Override
                    public void run(){
                        pd.dismiss();
                    }
                },count*1000);
            }
        });
        bt_start.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v)
            {
                new Thread(new Runnable(){
                    @Override
                    public void run(){
                        for(i=0;i<=100;i+=10){
                            if(i==100){
                                handler.post(new Runnable(){
                                    @Override
                                    public void run(){
                                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                                            pbar.setProgressTintList(ColorStateList.valueOf(Color.BLUE));
                                        }
                                        bt_start.setText("Finish");
                                    }
                                });
                            }
                            pbar.setProgress(i);
                            try{
                                Thread.sleep(300);
                            }
                            catch(Exception e){
                                e.printStackTrace();
                            }
                        }
                    }
                }).start();
            }
        });
    }
}
