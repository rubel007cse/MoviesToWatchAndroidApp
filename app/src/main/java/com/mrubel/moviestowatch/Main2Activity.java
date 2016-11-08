package com.mrubel.moviestowatch;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv = (TextView) findViewById(R.id.showing_data);

        // creating db object
        MyDbFunctions _db_obj = new MyDbFunctions(this);

        // calling method to get data
        String[] s = _db_obj.fetch_ALL_data();
        String y ="";


        // looping out data to 'y' varibale so that i can print later
        for(int i=0; i < s.length; i++){
            y =  y + s[i]+"\n\n";

        }

        // shwoing fetched data from database
        tv.setText(y);

    }
}
