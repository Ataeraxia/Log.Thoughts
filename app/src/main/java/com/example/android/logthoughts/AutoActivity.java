package com.example.android.logthoughts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AutoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auto);

        final String sitRecord;
        final String moodsRecord;

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                sitRecord = "Nothing to see here";
                moodsRecord = "Nothing to see here";
            } else {
                sitRecord = extras.getString("com.example.android.logthoughts.sitRecord");
                moodsRecord = extras.getString("com.example.android.logthoughts.moodsRecord");
            }
        } else {
            sitRecord = (String) savedInstanceState.getSerializable("com.example.android.logthoughts.sitRecord");
            moodsRecord = (String) savedInstanceState.getSerializable("com.example.android.logthoughts.moodsRecord");
        }

        Button nextAutoButton = (Button) findViewById(R.id.next_auto);

        nextAutoButton.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the next button is clicked on.
            @Override
            public void onClick(View view) {
                EditText getAutoRecord = (EditText) findViewById(R.id.auto);
                String autoRecord = getAutoRecord.getText().toString();

                Intent nextIntent = new Intent(AutoActivity.this, ProActivity.class);
                nextIntent = nextIntent.putExtra("com.example.android.logthoughts.sitRecord", sitRecord);
                nextIntent = nextIntent.putExtra("com.example.android.logthoughts.moodsRecord", moodsRecord);
                nextIntent = nextIntent.putExtra("com.example.android.logthoughts.autoRecord", autoRecord);
                startActivity(nextIntent);
            }
        });
    }
}
