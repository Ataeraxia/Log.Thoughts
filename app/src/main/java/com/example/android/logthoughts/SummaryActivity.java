package com.example.android.logthoughts;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SummaryActivity extends AppCompatActivity {

    String recordSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                recordSummary = "Nothing to see here";
            } else {
                recordSummary = extras.getString("com.example.android.logthoughts.sitRecord");
                recordSummary += System.getProperty("line.separator");
                recordSummary += extras.getString("com.example.android.logthoughts.moodsRecord");
                recordSummary += System.getProperty("line.separator");
                recordSummary += extras.getString("com.example.android.logthoughts.autoRecord");
                recordSummary += System.getProperty("line.separator");
                recordSummary += extras.getString("com.example.android.logthoughts.proRecord");
                recordSummary += System.getProperty("line.separator");
                recordSummary += extras.getString("com.example.android.logthoughts.conRecord");
                recordSummary += System.getProperty("line.separator");
                recordSummary += extras.getString("com.example.android.logthoughts.altRecord");
                recordSummary += System.getProperty("line.separator");
                recordSummary += extras.getString("com.example.android.logthoughts.nowRecord");
            }
        } else {
            recordSummary = (String) savedInstanceState.getSerializable("com.example.android.logthoughts.sitRecord");
            recordSummary += "\n";
            recordSummary += (String) savedInstanceState.getSerializable("com.example.android.logthoughts.moodsRecord");
            recordSummary += "\n";
            recordSummary += (String) savedInstanceState.getSerializable("com.example.android.logthoughts.autoRecord");
            recordSummary += "\n";
            recordSummary += (String) savedInstanceState.getSerializable("com.example.android.logthoughts.proRecord");
            recordSummary += "\n";
            recordSummary += (String) savedInstanceState.getSerializable("com.example.android.logthoughts.conRecord");
            recordSummary += "\n";
            recordSummary += (String) savedInstanceState.getSerializable("com.example.android.logthoughts.altRecord");
            recordSummary += "\n";
            recordSummary += (String) savedInstanceState.getSerializable("com.example.android.logthoughts.nowRecord");
        }

        displayRecordSummary();
    }

    public String createRecordSummary(){
        return recordSummary;
    }

    private void displayRecordSummary() {
        TextView summaryTextView = (TextView) findViewById(R.id.summary_text);
        summaryTextView.setText(recordSummary);
    }
}
