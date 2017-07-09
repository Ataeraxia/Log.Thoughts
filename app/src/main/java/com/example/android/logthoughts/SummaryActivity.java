package com.example.android.logthoughts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 *  SummaryActivity shows the user the answers they gave in the first 7 activities.
 *  Until the app is fixed to store the user's forms in the app (whether using SQL or text files),
 *      the user is expected to take a screenshot of this activity.
 *
 *  String thoughtsNull stores whether or not the extras bundle was null.
 *  Strings ending in RecordSummary store the answers for each of the 7 activities.
 *
 *  In the onCreate method, we set the content view to be the activity_summary xml layout.
 *  We then check to see if the activity has been loaded previously.
 *  If the activity has been loaded previously, we get the answers to the 7 activities through
 *      the savedInstanceState.
 *  If the activity has not been loaded previously, we check to see if the extras bundle is null.
 *  If the extras bundle is null, we set thoughtsNull to "Nothing to see here".
 *  If the extras bundle is not null, we get the answers to the 7 previous activities from
 *      the extras bundle, and store them in the global String variables ending in RecordSummary.
 *  We then run the displayRecordSummary() series of methods.
 *  These methods display the answers given by the user on the summary screen.
 */
public class SummaryActivity extends AppCompatActivity {

    static String LOG_TAG = "SUPERCAT";

    String sitThought;
    String moodsThought;
    String autoThought;
    String hotThought;
    String proThought;
    String conThought;
    String altThought;
    String nowThought;
    String emptyBundle = "Problem finding this info.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_summary);


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
                nowThought = emptyBundle;
            } else {
                sitThought = thought.getString("com.example.android.logthoughts.sitThought");
                moodsThought = thought.getString("com.example.android.logthoughts.moodsThought");
                autoThought = thought.getString("com.example.android.logthoughts.autoThought");
                hotThought = thought.getString("com.example.android.logthoughts.hotThought");
                proThought = thought.getString("com.example.android.logthoughts.proThought");
                conThought = thought.getString("com.example.android.logthoughts.conThought");
                altThought = thought.getString("com.example.android.logthoughts.altThought");
                nowThought = thought.getString("com.example.android.logthoughts.nowThought");
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
            nowThought = thought.getString("com.example.android.logthoughts.nowThought");
        }

        displaySitRecordSummary();
        displayMoodsRecordSummary();
        displayAutoRecordSummary();
        displayProRecordSummary();
        displayConRecordSummary();
        displayAltRecordSummary();
        displayNowRecordSummary();

//        // Save the thought record at this step
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
//        Date now = new Date();
//        String filename = "ThoughtRecord_" + formatter.format(now);
//        FileOutputStream outputStream;
//
//        try {
//            outputStream = openFileOutput(filename, Context.MODE_PRIVATE);
//            outputStream.write(sitThought.getBytes());
//            outputStream.write(moodsThought.getBytes());
//            outputStream.write(autoThought.getBytes());
//            outputStream.write(hotThought.getBytes());
//            outputStream.write(proThought.getBytes());
//            outputStream.write(conThought.getBytes());
//            outputStream.write(altThought.getBytes());
//            outputStream.write(nowThought.getBytes());
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

    }

    private void displaySitRecordSummary() {
        TextView summaryTextView = (TextView) findViewById(R.id.sit_summary_text);
        summaryTextView.setText(sitThought);
    }

    private void displayMoodsRecordSummary() {
        TextView summaryTextView = (TextView) findViewById(R.id.moods_summary_text);
        summaryTextView.setText(moodsThought);
    }

    private void displayAutoRecordSummary() {
        TextView summaryTextView = (TextView) findViewById(R.id.auto_summary_text);
        summaryTextView.setText(autoThought);
    }

    private void displayProRecordSummary() {
        TextView summaryTextView = (TextView) findViewById(R.id.pro_summary_text);
        summaryTextView.setText(proThought);
    }

    private void displayConRecordSummary() {
        TextView summaryTextView = (TextView) findViewById(R.id.con_summary_text);
        summaryTextView.setText(conThought);
    }

    private void displayAltRecordSummary() {
        TextView summaryTextView = (TextView) findViewById(R.id.alt_summary_text);
        summaryTextView.setText(altThought);
    }

    private void displayNowRecordSummary() {
        TextView summaryTextView = (TextView) findViewById(R.id.now_summary_text);
        summaryTextView.setText(nowThought);
    }

    public void restartThoughtRecord() {
        sitThought = null;
        moodsThought = null;
        autoThought = null;
        proThought = null;
        conThought = null;
        altThought = null;
        nowThought = null;

        Intent nextIntent = new Intent(SummaryActivity.this, SitActivity.class);
        startActivity(nextIntent);
    }

//    /* Checks if external storage is available for read and write */
//    public boolean isExternalStorageWritable() {
//        String state = Environment.getExternalStorageState();
//        if (Environment.MEDIA_MOUNTED.equals(state)) {
//            return true;
//        }
//        return false;
//    }
//
//    /* Checks if external storage is available to at least read */
//    public boolean isExternalStorageReadable() {
//        String state = Environment.getExternalStorageState();
//        if (Environment.MEDIA_MOUNTED.equals(state) ||
//                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
//            return true;
//        }
//        return false;
//    }
//
//    public File getAlbumStorageDir(Context context, String thoughtName) {
//        // Get the directory for the app's private documents directory.
//        File file = new File(context.getExternalFilesDir(
//                Environment.DIRECTORY_DOCUMENTS), thoughtName);
//        if (!file.mkdirs()) {
//            Log.e(LOG_TAG, "Directory not created");
//        }
//        return file;
//    }
}
