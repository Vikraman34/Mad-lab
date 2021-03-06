package com.example.sdcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Environment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    Button read,write;
    TextView ReadBox;
    EditText WriteBox;
    String fileName,filePath,fileContents;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        read =findViewById(R.id.Read);
        write = findViewById(R.id.Write);
        ReadBox = findViewById(R.id.ReadBox);
        WriteBox = findViewById(R.id.WriteBox);

        fileName ="myFile.txt";
        filePath = "FileDir";
        if(!isExternalStorageAvailableRW()){
            write.setEnabled(false);
        }
        write.setOnClickListener(view -> {
            ReadBox.setText("");
            fileContents = WriteBox.getText().toString().trim();
            if(!fileContents.equals("")) {
                //Get external files dir
                File myExtFile = new File(getExternalFilesDir(filePath), fileName);
                try {
                    FileOutputStream fos = new FileOutputStream(myExtFile);
                    fos.write(fileContents.getBytes());
                }
                catch (FileNotFoundException e){
                    e.printStackTrace();
                }
                catch (IOException e){
                    e.printStackTrace();
                }
                WriteBox.setText("");
                Toast.makeText(MainActivity.this, "TextFile written on SD Card"+myExtFile.getAbsolutePath(), Toast.LENGTH_SHORT).show();
            }
            else{
                Toast.makeText(MainActivity.this, "Input Field Empty", Toast.LENGTH_SHORT).show();
            }
        });
        read.setOnClickListener(view -> {
            FileReader fr;
            File myExtFile = new File(getExternalFilesDir(filePath),fileName);
            StringBuilder sb = new StringBuilder();
            String contents = "";
            try{
                fr = new FileReader(myExtFile);
                BufferedReader br = new BufferedReader(fr);
                String line = br.readLine();
                while(line!=null){
                    contents += line;
                    line = br.readLine();
                }
                ReadBox.setText(contents);
            }
            catch (FileNotFoundException e){
                e.printStackTrace();
            }
            catch (IOException e){
                e.printStackTrace();
            }

        });
    }

    private boolean isExternalStorageAvailableRW() {
        String ExternalStorageState = Environment.getExternalStorageState();
        if(ExternalStorageState.equals(Environment.MEDIA_MOUNTED)){
            return true;
        }
        return false;
    }
}