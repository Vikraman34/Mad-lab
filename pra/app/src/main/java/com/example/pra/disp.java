package com.example.pra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class disp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disp);

        EditText name=findViewById(R.id.name);
        Button back=findViewById(R.id.back);
        name.setText(getIntent().getStringExtra("name").toString());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(disp.this,MainActivity.class);
                finish();
                startActivity(intent);
            }
        });
    }
}