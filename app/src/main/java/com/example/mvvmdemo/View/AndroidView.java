package com.example.mvvmdemo.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvmdemo.R;


public class AndroidView extends AppCompatActivity {
    private AndroidLowerCaseViewModel lowerCaseViewModel;

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

        observeViewModel();

        textfield.setText(lowerCaseViewModel.getPresentableData().getValue());

    }

    private void observeViewModel() {
        lowerCaseViewModel = new ViewModelProvider(this).get(AndroidLowerCaseViewModel.class);

        final Observer<String> StringObserver = new Observer<String>() {
            @Override
            public void onChanged(String s) {

                textview.setText(s);
            }
        };

        lowerCaseViewModel.getPresentableData().observe(this, StringObserver);
    }

    public void enterInput(View view) {

        String input = textfield.getText().toString();
        lowerCaseViewModel.setInput(input);
    }
}
