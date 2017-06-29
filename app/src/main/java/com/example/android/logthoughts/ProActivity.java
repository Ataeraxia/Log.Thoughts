package com.example.android.logthoughts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ProActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pro);

        final String sitThought;
        final String moodsThought;
        final String autoThought;
        final String autoHotThought;
        String emptyBundle = getString(R.string.empty_bundle);

        if (savedInstanceState == null) {
            Bundle thought = getIntent().getExtras();
            if (thought == null) {
                sitThought = emptyBundle;
                moodsThought = emptyBundle;
                autoThought = emptyBundle;
                autoHotThought = emptyBundle;
            } else {
                sitThought = thought.getString("com.example.android.logthoughts.sitThought");
                moodsThought = thought.getString("com.example.android.logthoughts.moodsThought");
                autoThought = thought.getString("com.example.android.logthoughts.autoThought");
                autoHotThought = thought.getString("com.example.android.logthoughts.autoHotThought");
            }
        } else {
            // TODO: Figure out how savedInstanceState works and clean up this code
            Bundle thought = getIntent().getExtras();
            sitThought = thought.getString("com.example.android.logthoughts.sitThought");
            moodsThought = thought.getString("com.example.android.logthoughts.moodsThought");
            autoThought = thought.getString("com.example.android.logthoughts.autoThought");
            autoHotThought = thought.getString("com.example.android.logthoughts.autoHotThought");
        }

        TextView proPrevWin = (TextView) findViewById(R.id.pro_prev_win);
        proPrevWin.setText(autoHotThought);

        Button nextProButton = (Button) findViewById(R.id.next_pro);

        nextProButton.setOnClickListener(new View.OnClickListener() {

            // The code in this method will be executed when the next button is clicked on.
            @Override
            public void onClick(View view) {
                //Vars
                EditText proText = (EditText) findViewById(R.id.pro);
                Bundle thought = new Bundle();
                String proThought = proText.getText().toString();
                Intent nextIntent = new Intent(ProActivity.this, ConActivity.class);

                //Action
                thought.putString("com.example.android.logthoughts.sitThought", sitThought);
                thought.putString("com.example.android.logthoughts.moodsThought", moodsThought);
                thought.putString("com.example.android.logthoughts.autoThought", autoThought);
                thought.putString("com.example.android.logthoughts.autoHotThought", autoHotThought);
                thought.putString("com.example.android.logthoughts.proThought", proThought);
                nextIntent.putExtras(thought);
                startActivity(nextIntent);
            }
        });
    }
}
