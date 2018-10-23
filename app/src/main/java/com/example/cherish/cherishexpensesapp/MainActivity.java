package com.example.cherish.cherishexpensesapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fabExpense = (FloatingActionButton) findViewById(R.id.fabExpense);
        FloatingActionButton fabIncome = (FloatingActionButton) findViewById(R.id.fabIncome);

        fabExpense.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to start an AddExpenseActivity
                Intent addExpenseIntent = new Intent(MainActivity.this, AddExpenseActivity.class);
                startActivity(addExpenseIntent);
            }
        });

        fabIncome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Create a new intent to start an IncomeActivity
                Intent addIncomeIntent = new Intent(MainActivity.this, IncomeActivity.class);
                startActivity(addIncomeIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //clicking to see surplus/deficit income
        if (id == R.id.surplus) {
            Intent startSurplusActivity = new Intent(this, SurplusActivity.class);
            startActivity(startSurplusActivity);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
