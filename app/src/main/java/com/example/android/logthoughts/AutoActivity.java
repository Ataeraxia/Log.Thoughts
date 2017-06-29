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

        final String sitThought;
        final String moodsThought;
        String emptyBundle = getString(R.string.empty_bundle);

        if (savedInstanceState == null) {
            Bundle thought = getIntent().getExtras();
            if(thought == null) {
                sitThought = emptyBundle;
                moodsThought = emptyBundle;
            } else {
                sitThought = thought.getString("com.example.android.logthoughts.sitThought");
                moodsThought = thought.getString("com.example.android.logthoughts.moodsThought");
            }
        } else {
            // TODO: Figure out how savedInstanceState works and clean up this code
            Bundle thought = getIntent().getExtras();
            sitThought = thought.getString("com.example.android.logthoughts.sitThought");
            moodsThought = thought.getString("com.example.android.logthoughts.moodsThought");
        }

        Button nextAutoButton = (Button) findViewById(R.id.next_auto);

        nextAutoButton.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the next button is clicked on.
            @Override
            public void onClick(View view) {
                //Vars
                EditText autoText = (EditText) findViewById(R.id.auto);
                EditText autoHotText = (EditText) findViewById(R.id.auto_hot);
                Bundle thought = new Bundle();
                String autoThought = autoText.getText().toString();
                String autoHotThought = autoHotText.getText().toString();
                Intent nextIntent = new Intent(AutoActivity.this, ProActivity.class);

                //Action
                thought.putString("com.example.android.logthoughts.sitThought", sitThought);
                thought.putString("com.example.android.logthoughts.moodsThought", moodsThought);
                thought.putString("com.example.android.logthoughts.autoThought", autoThought);
                thought.putString("com.example.android.logthoughts.autoHotThought", autoHotThought);
                nextIntent.putExtras(thought);
                startActivity(nextIntent);
            }
        });
    }
}
