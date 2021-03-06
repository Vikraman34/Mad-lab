package com.example.ex5_alarm;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText et_time=findViewById(R.id.et_time);
        final AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
        final Intent i1=new Intent(getApplicationContext(),alarm.class);
        final PendingIntent pd=PendingIntent.getBroadcast(getApplicationContext(),0,i1,0);

        calendar= Calendar.getInstance();
        et_time.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    new TimePickerDialog(MainActivity.this,new TimePickerDialog.OnTimeSetListener(){
                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay, int minute){
                            et_time.setText(Integer.toString(hourOfDay)+":"+Integer.toString(minute));

                            calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                            calendar.set(Calendar.MINUTE,minute);

                            alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pd);
                            Toast.makeText(MainActivity.this,"Alarm ON", Toast.LENGTH_SHORT).show();
                        }
                    },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
                }
            }
        });

        et_time.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                new TimePickerDialog(MainActivity.this,new TimePickerDialog.OnTimeSetListener(){
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
                        et_time.setText(Integer.toString(hourOfDay)+":"+Integer.toString(minute));

                        calendar.set(Calendar.HOUR_OF_DAY,hourOfDay);
                        calendar.set(Calendar.MINUTE,minute);

                        alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pd);
                        Toast.makeText(MainActivity.this,"Alarm ON", Toast.LENGTH_SHORT).show();
                    }
                },calendar.get(Calendar.HOUR_OF_DAY),calendar.get(Calendar.MINUTE),false).show();
            }
        });
    }
}
