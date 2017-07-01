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
        final String hotThought;
        final String proThought;
        final String conThought;
        final String altThought;
        String emptyBundle = getString(R.string.empty_bundle);

        if (savedInstanceState == null) {
            Bundle thought = getIntent().getExtras();
            if(thought == null) {
                sitThought = emptyBundle;
                moodsThought = emptyBundle;
                autoThought = emptyBundle;
                hotThought = emptyBundle;
                proThought = emptyBundle;
                conThought = emptyBundle;
                altThought = emptyBundle;
            } else {
                sitThought = thought.getString("com.example.android.logthoughts.sitThought");
                moodsThought = thought.getString("com.example.android.logthoughts.moodsThought");
                autoThought = thought.getString("com.example.android.logthoughts.autoThought");
                hotThought = thought.getString("com.example.android.logthoughts.hotThought");
                proThought = thought.getString("com.example.android.logthoughts.proThought");
                conThought = thought.getString("com.example.android.logthoughts.conThought");
                altThought = thought.getString("com.example.android.logthoughts.altThought");
            }
        } else {
            // TODO: Figure out how savedInstanceState works and clean up this code
            Bundle thought = getIntent().getExtras();
            sitThought = thought.getString("com.example.android.logthoughts.sitThought");
            moodsThought = thought.getString("com.example.android.logthoughts.moodsThought");
            autoThought = thought.getString("com.example.android.logthoughts.autoThought");
            hotThought = thought.getString("com.example.android.logthoughts.hotThought");
            proThought = thought.getString("com.example.android.logthoughts.proThought");
            conThought = thought.getString("com.example.android.logthoughts.conThought");
            altThought = thought.getString("com.example.android.logthoughts.altThought");
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
                thought.putString("com.example.android.logthoughts.sitThought", sitThought);
                thought.putString("com.example.android.logthoughts.moodsThought", moodsThought);
                thought.putString("com.example.android.logthoughts.autoThought", autoThought);
                thought.putString("com.example.android.logthoughts.hotThought", hotThought);
                thought.putString("com.example.android.logthoughts.proThought", proThought);
                thought.putString("com.example.android.logthoughts.conThought", conThought);
                thought.putString("com.example.android.logthoughts.altThought", altThought);
                thought.putString("com.example.android.logthoughts.nowThought", nowThought);
                nextIntent.putExtras(thought);
                startActivity(nextIntent);
            }
        });
    }
}
