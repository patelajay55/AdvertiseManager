package com.qksoft.advertisemanager;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    String appId = "ca-app-pub-4906547187531410~1017165400";
    String test_Banner_Id = "ca-app-pub-3940256099942544/6300978111";
    String test_Interstatial_Id = "ca-app-pub-3940256099942544/1033173712";
    String orignal_Banner_Id = "ca-app-pub-4906547187531410/8704083733";
    String facebook_Test_id = "IMG_16_9_LINK#YOUR_PLACEMENT_ID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        LinearLayout adContainer = findViewById(R.id.linerLayout);


        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

}