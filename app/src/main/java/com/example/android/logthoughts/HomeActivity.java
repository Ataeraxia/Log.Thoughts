package com.example.android.logthoughts;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class HomeActivity extends AppCompatActivity {

    private static final String LOG_TAG = HomeActivity.class.getSimpleName();
    private static final String LOG_FLAG = " SUPERCAT";

    private String[] mMenu;
    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        mMenu = getResources().getStringArray(R.array.menu_strings);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        mDrawerList = (ListView) findViewById(R.id.drawer_list);

        // Set the adapter for the list view
        mDrawerList.setAdapter(new ArrayAdapter<String>(this,
                R.layout.menu_item, mMenu));
        // Set the list's click listener
        mDrawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                position = mDrawerList.getSelectedItemPosition();

                switch (position) {
                    case -1:
                        Log.e(LOG_TAG, "Error: Invalid item selection" + position + LOG_FLAG);
                        break;

                    case 0:
                        // This is supposed to bring the user to HomeActivity, which doesn't make sense
                        // TODO: Make the app into fragments I guess?
                        break;

                    case 1:
                        // TODO: Make a Recent Thoughts Activity
                        break;
                    case 2:
                        Intent sitIntent = new Intent(HomeActivity.this, SitActivity.class);
                        startActivity(sitIntent);
                        break;
                    case 3:
                        // TODO: Make a Check-In Activity
                        break;
                    case 4:
                        // TODO: Make a Calendar Activity
                        break;
                    default:
                        Log.d(LOG_TAG, "Case value exceeds 4, did you make new views? " + LOG_FLAG);
                }
            }
        });
    }
}
