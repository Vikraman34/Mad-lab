package com.example.practice;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class draw extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);

        Bitmap bg = Bitmap.createBitmap(720, 1280, Bitmap.Config.ARGB_8888);
        ImageView im1 = (ImageView) findViewById(R.id.imageView);
        im1.setBackgroundDrawable(new BitmapDrawable(bg));
        Canvas canvas = new Canvas(bg);
        Paint paint = new Paint();

        paint.setColor(Color.RED);
        paint.setTextSize(50);
        canvas.drawText("Hello", 100, 150, paint);

        canvas.drawRect(100, 300, 400, 400, paint);

        paint.setColor(Color.BLACK);
        paint.setTextSize(50);

        canvas.drawCircle(150, 425, 25, paint);
        canvas.drawCircle(350, 425, 25, paint);

        Button up=findViewById(R.id.button);
        Button down=findViewById(R.id.button2);
        Button left=findViewById(R.id.button3);
        Button right=findViewById(R.id.button4);

        left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im1.animate().translationXBy(300f).setDuration(600);
            }
        });

        right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im1.animate().translationXBy(-300f).setDuration(600);
            }
        });

        up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im1.animate().translationYBy(300f).setDuration(600);
            }
        });

        down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                im1.animate().translationYBy(-300f).setDuration(600);
            }
        });
    }
}