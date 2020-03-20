package com.example.mvvmdemo.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.mvvmdemo.R;

import java.util.Observable;
import java.util.Observer;

public class AndroidView extends AppCompatActivity {
    private LowerCasePresenter lowerCaseViewModel = new LowerCasePresenter();

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
        textview.setText(lowerCaseViewModel.getPresentableData());

        textfield.setText(lowerCaseViewModel.getPresentableData());

    }

    private void observeViewModel() {
        lowerCaseViewModel.addObserver(new Observer() {
            @Override
            public void update(Observable o, Object arg) {
                if (o instanceof LowerCasePresenter) {
                    String data = ((LowerCasePresenter) o).getPresentableData();
                    textview.setText(data);
                }
            }
        });

    }

    public void enterInput(View view) {

        String input = textfield.getText().toString();
        lowerCaseViewModel.setInput(input);
    }
}
