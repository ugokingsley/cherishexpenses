package com.example.cherish.cherishexpensesapp.data;

import android.net.Uri;
import android.provider.BaseColumns;


public class ExpenseContract {


    // The authority, which is how the code knows which Content Provider to access
    public static final String AUTHORITY = " com.example.cherish.cherishexpensesapp;";

    // The base content URI = "content://" + <authority>
    public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + AUTHORITY);


    // This is the path for the "Expenses" directory
    public static final String PATH_EXPENSES = "expenses";

    /* ExpenseEntry is an inner class that defines the contents of the Expense table */
    public static final class ExpenseEntry implements BaseColumns {

        // ExpenseEntry content URI = base content URI + path
        public static final Uri CONTENT_URI =
                BASE_CONTENT_URI.buildUpon().appendPath(PATH_EXPENSES).build();


        // expense table and column names
        public static final String TABLE_NAME = "expenses";

        // Since ExpenseEntry implements the interface "BaseColumns", it has an automatically produced
        // "_ID" column in addition to the two below
        public static final String COLUMN_TITLE = "title";
        public static final String COLUMN_DATE = "date";


    }
}
