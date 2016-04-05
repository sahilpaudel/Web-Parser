package com.example.sahilpaudel.webparserasync;

import android.content.Context;
import android.os.AsyncTask;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;


import org.htmlparser.parserapplications.LinkExtractor;
import org.htmlparser.parserapplications.StringExtractor;

/**
 * Created by Sahil Paudel on 4/2/2016.
 */
public class ParseWeb extends AsyncTask<String,Void,String>{

    EditText resultEditText;
    Context context;
    ProgressBar progressBar;

    public ParseWeb(Context context, EditText editText, ProgressBar progressBar) {
        resultEditText = editText;
        this.context = context;
        this.progressBar = progressBar;
    }


    @Override
    protected void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    protected String doInBackground(String... params) {

        try{

            String string = (String) params[0];
            StringExtractor stex = new StringExtractor(string);
            String content = stex.extractStrings(true);

            return content;
        }catch(Exception e){
            return new String("Exception: " + e.getMessage());
        }

    }

    @Override
    protected void onPostExecute(String s) {
        progressBar.setVisibility(View.GONE);
        this.resultEditText.setText(s);
    }
}
