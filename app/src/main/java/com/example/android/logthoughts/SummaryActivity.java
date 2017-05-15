package com.example.android.logthoughts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 *  SummaryActivity shows the user the answers they gave in the first 7 activities.
 *  Until the app is fixed to store the user's forms in the app (whether using SQL or text files),
 *      the user is expected to take a screenshot of this activity.
 *
 *  String recordSummaryNull stores whether or not the extras bundle was null.
 *  Strings ending in RecordSummary store the answers for each of the 7 activities.
 *
 *  In the onCreate method, we set the content view to be the activity_summary xml layout.
 *  We then check to see if the activity has been loaded previously.
 *  If the activity has been loaded previously, we get the answers to the 7 activities through
 *      the savedInstanceState.
 *  If the activity has not been loaded previously, we check to see if the extras bundle is null.
 *  If the extras bundle is null, we set recordSummaryNull to "Nothing to see here".
 *  If the extras bundle is not null, we get the answers to the 7 previous activities from
 *      the extras bundle, and store them in the global String variables ending in RecordSummary.
 *  We then run the displayRecordSummary() series of methods.
 *  These methods display the answers given by the user on the summary screen.
 */
public class SummaryActivity extends AppCompatActivity {

    String recordSummaryNull;
    String sitRecordSummary;
    String moodsRecordSummary;
    String autoRecordSummary;
    String proRecordSummary;
    String conRecordSummary;
    String altRecordSummary;
    String nowRecordSummary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);


        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                recordSummaryNull = "Nothing to see here";
            } else {
                sitRecordSummary = extras.getString("com.example.android.logthoughts.sitRecord");
                moodsRecordSummary = extras.getString("com.example.android.logthoughts.moodsRecord");
                autoRecordSummary = extras.getString("com.example.android.logthoughts.autoRecord");
                proRecordSummary = extras.getString("com.example.android.logthoughts.proRecord");
                conRecordSummary = extras.getString("com.example.android.logthoughts.conRecord");
                altRecordSummary = extras.getString("com.example.android.logthoughts.altRecord");
                nowRecordSummary = extras.getString("com.example.android.logthoughts.nowRecord");
            }
        } else {
            sitRecordSummary = (String) savedInstanceState.getSerializable("com.example.android.logthoughts.sitRecord");
            moodsRecordSummary = (String) savedInstanceState.getSerializable("com.example.android.logthoughts.moodsRecord");
            autoRecordSummary = (String) savedInstanceState.getSerializable("com.example.android.logthoughts.autoRecord");
            proRecordSummary = (String) savedInstanceState.getSerializable("com.example.android.logthoughts.proRecord");
            conRecordSummary = (String) savedInstanceState.getSerializable("com.example.android.logthoughts.conRecord");
            altRecordSummary = (String) savedInstanceState.getSerializable("com.example.android.logthoughts.altRecord");
            nowRecordSummary = (String) savedInstanceState.getSerializable("com.example.android.logthoughts.nowRecord");
        }

        displaySitRecordSummary();
        displayMoodsRecordSummary();
        displayAutoRecordSummary();
        displayProRecordSummary();
        displayConRecordSummary();
        displayAltRecordSummary();
        displayNowRecordSummary();
    }

    private void displaySitRecordSummary() {
        TextView summaryTextView = (TextView) findViewById(R.id.sit_summary_text);
        summaryTextView.setText(sitRecordSummary);
    }

    private void displayMoodsRecordSummary() {
        TextView summaryTextView = (TextView) findViewById(R.id.moods_summary_text);
        summaryTextView.setText(moodsRecordSummary);
    }

    private void displayAutoRecordSummary() {
        TextView summaryTextView = (TextView) findViewById(R.id.auto_summary_text);
        summaryTextView.setText(autoRecordSummary);
    }

    private void displayProRecordSummary() {
        TextView summaryTextView = (TextView) findViewById(R.id.pro_summary_text);
        summaryTextView.setText(proRecordSummary);
    }

    private void displayConRecordSummary() {
        TextView summaryTextView = (TextView) findViewById(R.id.con_summary_text);
        summaryTextView.setText(conRecordSummary);
    }

    private void displayAltRecordSummary() {
        TextView summaryTextView = (TextView) findViewById(R.id.alt_summary_text);
        summaryTextView.setText(altRecordSummary);
    }

    private void displayNowRecordSummary() {
        TextView summaryTextView = (TextView) findViewById(R.id.now_summary_text);
        summaryTextView.setText(nowRecordSummary);
    }

    public void restartThoughtRecord() {
        recordSummaryNull = null;
        sitRecordSummary = null;
        moodsRecordSummary = null;
        autoRecordSummary = null;
        proRecordSummary = null;
        conRecordSummary = null;
        altRecordSummary = null;
        nowRecordSummary = null;

        Intent nextIntent = new Intent(SummaryActivity.this, SitActivity.class);
        startActivity(nextIntent);
    }
}
