package com.example.pra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText name=findViewById(R.id.name);
        Button next=findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name_txt=name.getText().toString();
                Intent intent=new Intent(MainActivity.this,disp.class);
                intent.putExtra("name",name_txt);
                Toast.makeText(MainActivity.this,"bye",Toast.LENGTH_LONG).show();
                finish();
                startActivity(intent);
            }
        });
    }
}