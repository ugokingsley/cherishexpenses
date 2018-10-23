/*
* Copyright (C) 2016 The Android Open Source Project
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*      http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package com.example.cherish.cherishexpensesapp;

import android.content.Context;
import android.database.Cursor;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.cherish.cherishexpensesapp.data.ExpenseContract;

/**
 * This CustomCursorAdapter creates and binds ViewHolders, that hold the description and priority of an expense,
 * to a RecyclerView to efficiently display data.
 */
public class CustomCursorAdapter extends RecyclerView.Adapter<CustomCursorAdapter.ExpenseViewHolder> {

    // Class variables for the Cursor that holds task data and the Context
    private Cursor mCursor;
    private Context mContext;
    private TextView calendarViewExpense;

    /**
     * Constructor for the CustomCursorAdapter that initializes the Context.
     *
     * @param mContext the current Context
     */
    public CustomCursorAdapter(Context mContext) {
        this.mContext = mContext;
    }


    /**
     * Called when ViewHolders are created to fill a RecyclerView.
     *
     * @return A new ExpenseViewHolder that holds the view for each task
     */
    @Override
    public ExpenseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Inflate the task_layout to a view
        View view = LayoutInflater.from(mContext)
                .inflate(R.layout.expense_layout, parent, false);

        return new ExpenseViewHolder(view);
    }


    /**
     * Called by the RecyclerView to display data at a specified position in the Cursor.
     *
     * @param holder The ViewHolder to bind Cursor data to
     * @param position The position of the data in the Cursor
     */
    @Override
    public void onBindViewHolder(ExpenseViewHolder holder, int position) {

        // Indices for the _id, title, and date columns
        int idIndex = mCursor.getColumnIndex(ExpenseContract.ExpenseEntry._ID);
        int titleIndex = mCursor.getColumnIndex(ExpenseContract.ExpenseEntry.COLUMN_TITLE);
        int dateIndex = mCursor.getColumnIndex(ExpenseContract.ExpenseEntry.COLUMN_DATE);

        mCursor.moveToPosition(position); // get to the right location in the cursor

        // Determine the values of the wanted data
        final int id = mCursor.getInt(idIndex);
        String title = mCursor.getString(titleIndex);
        long date = mCursor.getInt(dateIndex);

        //Set values
        holder.itemView.setTag(id);
        holder.title.setText(title);
        holder.date.setDate(date);


    }


    /*
    Helper method for displayind date
    */
    public void onSelectedDayChange(CalendarView view, int year, int month, int day) {
    // display the new date on the text view

        calendarViewExpense.setText( + year + "-" + month + "-" + day);

    }


    /**
     * Returns the number of items to display.
     */
    @Override
    public int getItemCount() {
        if (mCursor == null) {
            return 0;
        }
        return mCursor.getCount();
    }


    /**
     * When data changes and a re-query occurs, this function swaps the old Cursor
     * with a newly updated Cursor (Cursor c) that is passed in.
     */
    public Cursor swapCursor(Cursor c) {
        // check if this cursor is the same as the previous cursor (mCursor)
        if (mCursor == c) {
            return null; // bc nothing has changed
        }
        Cursor temp = mCursor;
        this.mCursor = c; // new cursor value assigned

        //check if this is a valid cursor, then update the cursor
        if (c != null) {
            this.notifyDataSetChanged();
        }
        return temp;
    }


    // Inner class for creating ViewHolders
    class ExpenseViewHolder extends RecyclerView.ViewHolder {

        // Class variables for the expense description and priority TextViews
        TextView title;
        CalendarView date;

        /**
         * Constructor for the ExpenseViewHolders.
         *
         * @param itemView The view inflated in onCreateViewHolder
         */
        public ExpenseViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.editTextExpenseTitle);
            date = (CalendarView) itemView.findViewById(R.id.calendarViewExpense);
        }
    }
}