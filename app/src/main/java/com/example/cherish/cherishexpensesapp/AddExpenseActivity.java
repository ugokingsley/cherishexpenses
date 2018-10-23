package com.example.cherish.cherishexpensesapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.TextView;
import android.content.ContentValues;
import android.widget.Toast;

import com.example.cherish.cherishexpensesapp.data.ExpenseContract;

public class AddExpenseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);


    }

    /**
     * onClickAddExpense is called when the "ADD" button is clicked.
     * It retrieves user input and inserts that new expense data into the underlying database.
     */
    public void onClickAddExpense(View view) {
        // Check if EditText is empty, if not retrieve title and store it in a ContentValues object
        // If the EditText title is empty -> don't create an entry
        String title = ((EditText) findViewById(R.id.editTextExpenseTitle)).getText().toString();
        if (title.length() == 0) {
            return;
        }

        long date = ((CalendarView) findViewById(R.id.calendarViewExpense)).getDate();
        if (date == 0) {
            return;
        }



        // Insert new task data via a ContentResolver
        // Create new empty ContentValues object
        ContentValues contentValues = new ContentValues();
        // Put the task description and selected mPriority into the ContentValues
        contentValues.put(ExpenseContract.ExpenseEntry.COLUMN_TITLE, title);
        contentValues.put(ExpenseContract.ExpenseEntry.COLUMN_DATE, date);
        // Insert the content values via a ContentResolver
        Uri uri = getContentResolver().insert(ExpenseContract.ExpenseEntry.CONTENT_URI, contentValues);

        // Display the URI that's returned with a Toast
        // [Hint] Don't forget to call finish() to return to MainActivity after this insert is complete
        if(uri != null) {
            Toast.makeText(getBaseContext(), uri.toString(), Toast.LENGTH_LONG).show();
        }

        // Finish activity (this returns back to MainActivity)
        finish();

    }
}
