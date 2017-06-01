package com.example.android.logthoughts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MoodsActivity extends AppCompatActivity {

    String sitRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moods);

        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                sitRecord = "Nothing to see here";
            } else {
                sitRecord = extras.getString("com.example.android.logthoughts.sitRecord");
            }
        } else {
            sitRecord = (String) savedInstanceState.getSerializable("com.example.android.logthoughts.sitRecord");
        }

        Button nextMoodsButton = (Button) findViewById(R.id.next_moods);

        nextMoodsButton.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the next button is clicked on.
            @Override
            public void onClick(View view) {
                EditText getMoodsRecord = (EditText) findViewById(R.id.moods_edit);
                String moodsRecord = getMoodsRecord.getText().toString();

                Intent nextIntent = new Intent(MoodsActivity.this, AutoActivity.class);
                nextIntent = nextIntent.putExtra("com.example.android.logthoughts.sitRecord", sitRecord);
                nextIntent = nextIntent.putExtra("com.example.android.logthoughts.moodsRecord", moodsRecord);
                startActivity(nextIntent);
            }
        });

        final TextView moodsHelpText = (TextView) findViewById(R.id.help_text);

        moodsHelpText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent moodsHelpIntent = new Intent(MoodsActivity.this, MoodsHelp.class);
                startActivity(moodsHelpIntent);
            }
        });
    }
}
