package com.example.cherish.cherishexpensesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;

public class SurplusActivity extends AppCompatActivity {

    private TextView surplus_display;
    private CalendarView surplus_calender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surplus);

        // pull the views from the XML
        surplus_display = (TextView) findViewById(R.id.calendarViewSurplusText);
        surplus_calender = (CalendarView) findViewById(R.id.calendarViewSurplus);

        // set a listener on the calender view to listen for changes in the date

        surplus_calender.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            // overridden method that will be called whenever the user changes the date

            public void onSelectedDayChange(CalendarView view, int year, int month, int day) {

                // display the new date on the text view
                surplus_display.setText("Surplus for  " + year + "-" + month + "-" + day + ":  $2000");
            }
        });

    }


}
