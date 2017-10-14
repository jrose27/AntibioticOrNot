package com.borregobrothers.jrose.antibioticornot;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.view.View;
import android.content.Intent;


public class TitleScreenActivity extends AppCompatActivity {


    private final static String TAG = " Look for StUpId --> ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_title_screen_layout);

        Log.v(TAG, "The title screen activity has started!");

        Button startButton = (Button) findViewById(R.id.startButton);
        assert startButton != null;
        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Start the new activity
                startActivity(new Intent(TitleScreenActivity.this, QuestionnaireOneActivity.class));
                Log.v(TAG, "Start Button was Clicked!");
            }
        });

    } // Closes the onCreate method
}