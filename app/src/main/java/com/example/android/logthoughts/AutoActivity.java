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

        if (savedInstanceState == null) {
            Bundle thought = getIntent().getExtras();
            if(thought == null) {
                sitThought = "Nothing to see here";
                moodsThought = "Nothing to see here";
            } else {
                sitThought = thought.getString("com.example.android.logthoughts.sitRecord");
                moodsThought = thought.getString("com.example.android.logthoughts.moodsRecord");
            }
        } else {
            // TODO: Figure out how savedInstanceState works and clean up this code
            Bundle thought = getIntent().getExtras();
            sitThought = thought.getString("com.example.android.logthoughts.sitRecord");
            moodsThought = thought.getString("com.example.android.logthoughts.moodsRecord");
        }

        Button nextAutoButton = (Button) findViewById(R.id.next_auto);

        nextAutoButton.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the next button is clicked on.
            @Override
            public void onClick(View view) {
                //Vars
                EditText autoText = (EditText) findViewById(R.id.auto);
                Bundle thought = new Bundle();
                String autoThought = autoText.getText().toString();
                Intent nextIntent = new Intent(AutoActivity.this, ProActivity.class);

                //Action
                thought.putString("com.example.android.logthoughts.sitRecord", sitThought);
                thought.putString("com.example.android.logthoughts.moodsRecord", moodsThought);
                thought.putString("com.example.android.logthoughts.autoRecord", autoThought);
                nextIntent.putExtras(thought);
                startActivity(nextIntent);
            }
        });
    }
}
