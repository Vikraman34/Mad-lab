package com.example.newcal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.fathzer.soft.javaluator.DoubleEvaluator;

public class MainActivity extends AppCompatActivity {

    Button button0, button1, button2, button3, button4, button5, button6,
            button7, button8, button9, buttonAdd, buttonSub, buttonDiv,
            buttonMul, button10, buttonC, buttonEqual,buttonMod,buttonPow;
    EditText display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button0 =findViewById(R.id.zero);
        button1 =findViewById(R.id.one);
        button2 =findViewById(R.id.two);
        button3 =findViewById(R.id.three);
        button4 =findViewById(R.id.four);
        button5 =findViewById(R.id.five);
        button6 =findViewById(R.id.six);
        button7 =findViewById(R.id.seven);
        button8 =findViewById(R.id.eight);
        button9 =findViewById(R.id.nine);
        button10 =findViewById(R.id.decimal);
        buttonAdd =findViewById(R.id.add);
        buttonSub =findViewById(R.id.sub);
        buttonMul =findViewById(R.id.mul);
        buttonDiv =findViewById(R.id.div);
        buttonMod=findViewById(R.id.mod);
        buttonPow=findViewById(R.id.power);
        buttonC =findViewById(R.id.clr);
        buttonEqual =findViewById(R.id.equal);
        display =findViewById(R.id.result);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "1");
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "2");
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "3");
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "4");
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "5");
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "6");
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "(");
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + ")");
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "9");
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + "0");
            }
        });

        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { display.setText(display.getText() + "+"); }
        });

        buttonSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { display.setText(display.getText() + "-"); }
        });

        buttonMul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { display.setText(display.getText() + "*"); }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { display.setText(display.getText() + "/"); }
        });

        buttonMod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { display.setText(display.getText() + "%"); }
        });

        buttonPow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) { display.setText(display.getText() + "^"); }
        });

        buttonEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String val=display.getText().toString();
                String vi;
                try{
                vi=new DoubleEvaluator().evaluate(val).toString();}
                catch (Exception e){
                    vi="Error";
                }
                display.setText(vi);
            }
        });

        buttonC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText("");
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText() + ".");
            }
        });
    }
}


//file->project structure->dependencies-> + -> library dependency
//com.fathzer:javaluator:3.0.3
//Add as implementation in gradle and sync.
//Use new DoubleEvaluator().evaluate (Expression as string) to get output for calc