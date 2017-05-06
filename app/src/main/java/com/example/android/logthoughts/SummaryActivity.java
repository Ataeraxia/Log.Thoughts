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
                recordSummary= extras.getString("com.example.android.logthoughts.sitRecord");
            }
        } else {
            recordSummary= (String) savedInstanceState.getSerializable("com.example.android.logthoughts.sitRecord");
        }

        displyRecordSummary();
    }

    public String createRecordSummary(){
        return recordSummary;
    }

    private void displyRecordSummary() {
        TextView summaryTextView = (TextView) findViewById(R.id.summary_text);
        summaryTextView.setText(recordSummary);
    }
}
