package com.example.sahilpaudel.webparserasync;

import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText urlEditText;
    EditText outputEditText;
    Button fetchButton,clearButton;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        urlEditText = (EditText) findViewById(R.id.url_link);
        outputEditText = (EditText) findViewById(R.id.output);
        fetchButton = (Button) findViewById(R.id.fetch);
        clearButton = (Button) findViewById(R.id.clear);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);

        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                urlEditText.setText("");
                outputEditText.setText("");
            }
        });


        fetchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                justAction();
            }
        });
    }

    public void justAction() {
        String url = urlEditText.getText().toString();
        new ParseWeb(this,outputEditText,progressBar).execute(url);
    }
}
