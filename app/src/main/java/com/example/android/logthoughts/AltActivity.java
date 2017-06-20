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

        final String sitThought;
        final String moodsThought;
        final String autoThought;
        final String proThought;
        final String conThought;

        if (savedInstanceState == null) {
            Bundle thought = getIntent().getExtras();
            if(thought == null) {
                sitThought = "Nothing to see here";
                moodsThought = "Nothing to see here";
                autoThought = "Nothing to see here";
                proThought = "Nothing to see here";
                conThought = "Nothing to see here";
            } else {
                sitThought = thought.getString("com.example.android.logthoughts.sitRecord");
                moodsThought = thought.getString("com.example.android.logthoughts.moodsRecord");
                autoThought = thought.getString("com.example.android.logthoughts.autoRecord");
                proThought = thought.getString("com.example.android.logthoughts.proRecord");
                conThought = thought.getString("com.example.android.logthoughts.conRecord");
            }
        } else {
            // TODO: Figure out how savedInstanceState works and clean up this code
            Bundle thought = getIntent().getExtras();
            sitThought = thought.getString("com.example.android.logthoughts.sitRecord");
            moodsThought = thought.getString("com.example.android.logthoughts.moodsRecord");
            autoThought = thought.getString("com.example.android.logthoughts.autoRecord");
            proThought = thought.getString("com.example.android.logthoughts.proRecord");
            conThought = thought.getString("com.example.android.logthoughts.conRecord");
        }

        Button nextAltButton = (Button) findViewById(R.id.next_alt);

        nextAltButton.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the next button is clicked on.
            @Override
            public void onClick(View view) {
                //Vars
                EditText altText = (EditText) findViewById(R.id.alt);
                Bundle thought = new Bundle();
                String altThought = altText.getText().toString();
                Intent nextIntent = new Intent(AltActivity.this, NowActivity.class);

                //Action
                thought.putString("com.example.android.logthoughts.sitRecord", sitThought);
                thought.putString("com.example.android.logthoughts.moodsRecord", moodsThought);
                thought.putString("com.example.android.logthoughts.autoRecord", autoThought);
                thought.putString("com.example.android.logthoughts.proRecord", proThought);
                thought.putString("com.example.android.logthoughts.conRecord", conThought);
                thought.putString("com.example.android.logthoughts.altRecord", altThought);
                nextIntent.putExtras(thought);
                startActivity(nextIntent);
            }
        });
    }
}
