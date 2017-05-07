package com.example.android.logthoughts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AltActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alt);

        final String sitRecord;
        final String moodsRecord;
        final String autoRecord;
        final String proRecord;
        final String conRecord;

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                sitRecord = "Nothing to see here";
                moodsRecord = "Nothing to see here";
                autoRecord = "Nothing to see here";
                proRecord = "Nothing to see here";
                conRecord = "Nothing to see here";
            } else {
                sitRecord = extras.getString("com.example.android.logthoughts.sitRecord");
                moodsRecord = extras.getString("com.example.android.logthoughts.moodsRecord");
                autoRecord = extras.getString("com.example.android.logthoughts.autoRecord");
                proRecord = extras.getString("com.example.android.logthoughts.proRecord");
                conRecord = extras.getString("com.example.android.logthoughts.conRecord");

            }
        } else {
            sitRecord = (String) savedInstanceState.getSerializable("com.example.android.logthoughts.sitRecord");
            moodsRecord = (String) savedInstanceState.getSerializable("com.example.android.logthoughts.moodsRecord");
            autoRecord = (String) savedInstanceState.getSerializable("com.example.android.logthoughts.autoRecord");
            proRecord = (String) savedInstanceState.getSerializable("com.example.android.logthoughts.proRecord");
            conRecord = (String) savedInstanceState.getSerializable("com.example.android.logthoughts.conRecord");

        }

        Button nextAltButton = (Button) findViewById(R.id.next_alt);

        nextAltButton.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the next button is clicked on.
            @Override
            public void onClick(View view) {
                EditText getAltRecord = (EditText) findViewById(R.id.alt);
                String altRecord = getAltRecord.getText().toString();

                Intent nextIntent = new Intent(AltActivity.this, NowActivity.class);
                nextIntent = nextIntent.putExtra("com.example.android.logthoughts.sitRecord", sitRecord);
                nextIntent = nextIntent.putExtra("com.example.android.logthoughts.moodsRecord", moodsRecord);
                nextIntent = nextIntent.putExtra("com.example.android.logthoughts.autoRecord", autoRecord);
                nextIntent = nextIntent.putExtra("com.example.android.logthoughts.proRecord", proRecord);
                nextIntent = nextIntent.putExtra("com.example.android.logthoughts.conRecord", conRecord);
                nextIntent = nextIntent.putExtra("com.example.android.logthoughts.altRecord", altRecord);
                startActivity(nextIntent);
            }
        });
    }
}
