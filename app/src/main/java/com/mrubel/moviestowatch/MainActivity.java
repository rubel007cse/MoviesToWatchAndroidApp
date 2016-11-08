package com.mrubel.moviestowatch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {


    Button _save;
    EditText _movie_title, _movie_details;

    MyDbFunctions db_object = new MyDbFunctions(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _save = (Button) findViewById(R.id.savedata);
        _movie_title = (EditText) findViewById(R.id.nameofmovie);
        _movie_details = (EditText) findViewById(R.id.moviedetails);

        _save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // adding data to database
                db_object.addNewDATA(new DataTemp(_movie_title.getText().toString(), _movie_details.getText().toString(),
                        get_saving_date()));
                Toast.makeText(getApplicationContext(), "Saved Successfully!", Toast.LENGTH_LONG).show();
            }
        });





    }


    // method to get current date
    String get_saving_date(){

        String[] monthNames = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        return monthNames[month]+" "+day+", "+year;
    }


    void goToSecondActivity(View v){
        startActivity(new Intent(getApplicationContext(), Main2Activity.class));
    }

}
