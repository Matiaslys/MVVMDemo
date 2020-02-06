package com.example.mvvmdemo;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;




public class MainActivity extends AppCompatActivity {

    TextView textview;
    Button mainBtn;
    EditText textfield;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textview = findViewById(R.id.textView);
        mainBtn = findViewById(R.id.MainBtn);
        textfield = findViewById(R.id.TextField);





        mainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String string = textfield.getText().toString();
                textview.setText(string);
            }
        });
    }
}
