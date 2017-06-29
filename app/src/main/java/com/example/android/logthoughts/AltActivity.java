package com.example.android.logthoughts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class AltActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alt);

        final String sitThought;
        final String moodsThought;
        final String autoThought;
        final String hotThought;
        final String proThought;
        final String conThought;
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
            } else {
                sitThought = thought.getString("com.example.android.logthoughts.sitThought");
                moodsThought = thought.getString("com.example.android.logthoughts.moodsThought");
                autoThought = thought.getString("com.example.android.logthoughts.autoThought");
                hotThought = thought.getString("com.example.android.logthoughts.hotThought");
                proThought = thought.getString("com.example.android.logthoughts.proThought");
                conThought = thought.getString("com.example.android.logthoughts.conThought");
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
        }

        TextView altProWin = (TextView) findViewById(R.id.alt_prev_pro_win);
        altProWin.setText(proThought);
        TextView altConWin = (TextView) findViewById(R.id.alt_prev_con_win);
        altConWin.setText(conThought);

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
                thought.putString("com.example.android.logthoughts.sitThought", sitThought);
                thought.putString("com.example.android.logthoughts.moodsThought", moodsThought);
                thought.putString("com.example.android.logthoughts.autoThought", autoThought);
                thought.putString("com.example.android.logthoughts.hotThought", hotThought);
                thought.putString("com.example.android.logthoughts.proThought", proThought);
                thought.putString("com.example.android.logthoughts.conThought", conThought);
                thought.putString("com.example.android.logthoughts.altThought", altThought);
                nextIntent.putExtras(thought);
                startActivity(nextIntent);
            }
        });
    }
}
