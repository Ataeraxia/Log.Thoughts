package com.example.android.logthoughts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class NowActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now);

        final String sitThought;
        final String moodsThought;
        final String autoThought;
        final String proThought;
        final String conThought;
        final String altThought;

        if (savedInstanceState == null) {
            Bundle thought = getIntent().getExtras();
            if(thought == null) {
                sitThought = "Nothing to see here";
                moodsThought = "Nothing to see here";
                autoThought = "Nothing to see here";
                proThought = "Nothing to see here";
                conThought = "Nothing to see here";
                altThought = "Nothing to see here";
            } else {
                sitThought = thought.getString("com.example.android.logthoughts.sitRecord");
                moodsThought = thought.getString("com.example.android.logthoughts.moodsRecord");
                autoThought = thought.getString("com.example.android.logthoughts.autoRecord");
                proThought = thought.getString("com.example.android.logthoughts.proRecord");
                conThought = thought.getString("com.example.android.logthoughts.conRecord");
                altThought = thought.getString("com.example.android.logthoughts.altRecord");
            }
        } else {
            // TODO: Figure out how savedInstanceState works and clean up this code
            Bundle thought = getIntent().getExtras();
            sitThought = thought.getString("com.example.android.logthoughts.sitRecord");
            moodsThought = thought.getString("com.example.android.logthoughts.moodsRecord");
            autoThought = thought.getString("com.example.android.logthoughts.autoRecord");
            proThought = thought.getString("com.example.android.logthoughts.proRecord");
            conThought = thought.getString("com.example.android.logthoughts.conRecord");
            altThought = thought.getString("com.example.android.logthoughts.altRecord");
        }

        TextView nowPrevWin = (TextView) findViewById(R.id.now_prev_win);
        if (moodsThought != null) {nowPrevWin.setText(moodsThought);}

        Button nextNowButton = (Button) findViewById(R.id.next_now);

        nextNowButton.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the next button is clicked on.
            @Override
            public void onClick(View view) {
                //Vars
                EditText nowText = (EditText) findViewById(R.id.now);
                Bundle thought = new Bundle();
                String nowThought = nowText.getText().toString();
                Intent nextIntent = new Intent(NowActivity.this, SummaryActivity.class);

                //Actions
                thought.putString("com.example.android.logthoughts.sitRecord", sitThought);
                thought.putString("com.example.android.logthoughts.moodsRecord", moodsThought);
                thought.putString("com.example.android.logthoughts.autoRecord", autoThought);
                thought.putString("com.example.android.logthoughts.proRecord", proThought);
                thought.putString("com.example.android.logthoughts.conRecord", conThought);
                thought.putString("com.example.android.logthoughts.altRecord", altThought);
                thought.putString("com.example.android.logthoughts.nowRecord", nowThought);
                nextIntent.putExtras(thought);
                startActivity(nextIntent);
            }
        });
    }
}
