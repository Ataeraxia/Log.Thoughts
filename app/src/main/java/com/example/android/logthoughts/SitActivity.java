package com.example.android.logthoughts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SitActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sit);

        Button nextSitButton = (Button) findViewById(R.id.next_sit);

        nextSitButton.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the next button is clicked on.
            @Override
            public void onClick(View view) {
                EditText getSitRecord = (EditText) findViewById(R.id.sit);
                String sitRecord = getSitRecord.getText().toString();

                Intent nextIntent = new Intent(SitActivity.this, MoodsActivity.class);
                nextIntent = nextIntent.putExtra("com.example.android.logthoughts.sitRecord", sitRecord);
                startActivity(nextIntent);
            }
        });
    }
}
