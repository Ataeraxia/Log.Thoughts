package com.example.android.logthoughts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MoodsActivity extends AppCompatActivity {

    String sitThought;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_moods);

        if (savedInstanceState == null) {
            Bundle thought = getIntent().getExtras();
            if(thought == null) {
                sitThought = getString(R.string.empty_bundle);
            } else {
                sitThought = thought.getString("com.example.android.logthoughts.sitThought");
            }
        } else {
            // TODO: Figure out how savedInstanceState works and clean up this code
            Bundle thought = getIntent().getExtras();
            sitThought = thought.getString("com.example.android.logthoughts.sitThought");
        }

        Button nextMoodsButton = (Button) findViewById(R.id.next_moods);

        nextMoodsButton.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the next button is clicked on.
            @Override
            public void onClick(View view) {
                //Vars
                EditText moodsText = (EditText) findViewById(R.id.moods_edit);
                Bundle thought = new Bundle();
                String moodsThought = moodsText.getText().toString();
                Intent nextIntent = new Intent(MoodsActivity.this, AutoActivity.class);

                //Action
                thought.putString("com.example.android.logthoughts.sitThought", sitThought);
                thought.putString("com.example.android.logthoughts.moodsThought", moodsThought);
                nextIntent.putExtras(thought);
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
