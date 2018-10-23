package com.example.cherish.cherishexpensesapp.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.cherish.cherishexpensesapp.data.ExpenseContract.ExpenseEntry;


public class ExpenseDbHelper extends SQLiteOpenHelper {

    // The name of the database
    private static final String DATABASE_NAME = "ExpenseDb.db";

    // If you change the database schema, you must increment the database version
    private static final int VERSION = 2;


    // Constructor
    ExpenseDbHelper(Context context) {
        super(context, DATABASE_NAME, null, VERSION);
    }


    /**
     * Called when the tasks database is created for the first time.
     */
    @Override
    public void onCreate(SQLiteDatabase db) {

        // Create expenses table
        final String CREATE_TABLE = "CREATE TABLE "     + ExpenseEntry.TABLE_NAME + " (" +
                        ExpenseEntry._ID                + " INTEGER PRIMARY KEY, " +
                        ExpenseEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
                        ExpenseEntry.COLUMN_DATE + " INTEGER NOT NULL);";

        db.execSQL(CREATE_TABLE);
    }


    /**
     * This method discards the old table of data and calls onCreate to recreate a new one.
     * This only occurs when the version number for this database (DATABASE_VERSION) is incremented.
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + ExpenseEntry.TABLE_NAME);
        onCreate(db);
    }
}
