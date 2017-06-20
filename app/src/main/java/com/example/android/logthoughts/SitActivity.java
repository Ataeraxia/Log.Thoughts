package com.example.android.logthoughts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


// TODO: Add EditText for place
// TODO: Add EditText for time
// TODO: Call and response format? | What time is it? [EditText]
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
                // Vars
                EditText sitText = (EditText) findViewById(R.id.sit_edit);
                Bundle thought = new Bundle();
                String sitThought = sitText.getText().toString();
                Intent nextIntent = new Intent(SitActivity.this, MoodsActivity.class);

                //Action
                thought.putString("com.example.android.logthoughts.sitRecord", sitThought);
                nextIntent = nextIntent.putExtras(thought);
                startActivity(nextIntent);
            }
        });

        final TextView sitHelpText = (TextView) findViewById(R.id.help_text);

        sitHelpText.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent sitHelpIntent = new Intent(SitActivity.this, SitHelpActivity.class);
                startActivity(sitHelpIntent);
            }
        });
    }
}
