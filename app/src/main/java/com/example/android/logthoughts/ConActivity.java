package com.example.android.logthoughts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ConActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_con);

        final String sitThought;
        final String moodsThought;
        final String autoThought;
        final String proThought;

        if (savedInstanceState == null) {
            Bundle thought = getIntent().getExtras();
            if(thought == null) {
                sitThought = "Nothing to see here";
                moodsThought = "Nothing to see here";
                autoThought = "Nothing to see here";
                proThought = "Nothing to see here";
            } else {
                sitThought = thought.getString("com.example.android.logthoughts.sitRecord");
                moodsThought = thought.getString("com.example.android.logthoughts.moodsRecord");
                autoThought = thought.getString("com.example.android.logthoughts.autoRecord");
                proThought = thought.getString("com.example.android.logthoughts.proRecord");

            }
        } else {
            // TODO: Figure out how savedInstanceState works and clean up this code
            Bundle thought = getIntent().getExtras();
            sitThought = thought.getString("com.example.android.logthoughts.sitRecord");
            moodsThought = thought.getString("com.example.android.logthoughts.moodsRecord");
            autoThought = thought.getString("com.example.android.logthoughts.autoRecord");
            proThought = thought.getString("com.example.android.logthoughts.proRecord");

        }

        Button nextConButton = (Button) findViewById(R.id.next_con);

        nextConButton.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the next button is clicked on.
            @Override
            public void onClick(View view) {
                //Vars
                EditText conText = (EditText) findViewById(R.id.con);
                Bundle thought = new Bundle();
                String conThought = conText.getText().toString();
                Intent nextIntent = new Intent(ConActivity.this, AltActivity.class);

                //Action
                thought.putString("com.example.android.logthoughts.sitRecord", sitThought);
                thought.putString("com.example.android.logthoughts.moodsRecord", moodsThought);
                thought.putString("com.example.android.logthoughts.autoRecord", autoThought);
                thought.putString("com.example.android.logthoughts.proRecord", proThought);
                thought.putString("com.example.android.logthoughts.conRecord", conThought);
                nextIntent.putExtras(thought);
                startActivity(nextIntent);
            }
        });
    }
}
