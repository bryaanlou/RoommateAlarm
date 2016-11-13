package com.example.andrew.fkyouralarm;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class AlarmsScreen extends AppCompatActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(com.example.andrew.fkyouralarm.R.layout.activity_alarms_screen);
    }

    /**
     * Test to populate the pair label table
     */
    public void populateList2(View view)
    {
        TableLayout ll = (TableLayout) findViewById(com.example.andrew.fkyouralarm.R.id.personalTable);

        for (int i = 0; i < 1; i++)
        {
            TableRow row= new TableRow(this);

            TableRow.LayoutParams lp = new TableRow.LayoutParams(ll.getWidth(),TableRow.LayoutParams.WRAP_CONTENT);
            lp.setMargins(1, 1, 1, 1);
            row.setLayoutParams(lp);

            TableRow.LayoutParams llp = new TableRow.LayoutParams(ll.getWidth()-3,TableLayout.LayoutParams.WRAP_CONTENT);
            llp.setMargins(1, 1, 1, 1);

            LinearLayout outercell = new LinearLayout(this);
            LinearLayout innercell = new LinearLayout(this);

            outercell.setBackgroundColor(Color.BLACK);
            innercell.setBackgroundColor(Color.WHITE);

            outercell.setLayoutParams(llp);//2px border on the right for the cell
            innercell.setLayoutParams(llp);

            TextView tv = new TextView(this);
            tv.setText(Integer.toString(i));

            innercell.addView(tv);
            outercell.addView(innercell);
            row.addView(outercell);
            ll.addView(row,i);
        }
    }

    public void addAlarm(View view)
    {
        Intent intent = new Intent(this, AddAlarmMenu.class);
        startActivity(intent);
    }

    public void populateList(View view)
    {
        TableLayout ll = (TableLayout) findViewById(com.example.andrew.fkyouralarm.R.id.pairedTable);

        for (int i = 0; i < 1; i++)
        {
            TableRow row= new TableRow(this);

            TableRow.LayoutParams lp = new TableRow.LayoutParams(ll.getWidth(),TableRow.LayoutParams.WRAP_CONTENT);
            lp.setMargins(1, 1, 1, 1);
            row.setLayoutParams(lp);

            TableRow.LayoutParams llp = new TableRow.LayoutParams(ll.getWidth()-3,TableLayout.LayoutParams.WRAP_CONTENT);
            llp.setMargins(1, 1, 1, 1);

            LinearLayout outercell = new LinearLayout(this);
            LinearLayout innercell = new LinearLayout(this);

            outercell.setBackgroundColor(Color.BLACK);
            innercell.setBackgroundColor(Color.WHITE);

            outercell.setLayoutParams(llp);//2px border on the right for the cell
            innercell.setLayoutParams(llp);

            TextView tv = new TextView(this);
            tv.setText(Integer.toString(i));

            innercell.addView(tv);
            outercell.addView(innercell);
            row.addView(outercell);
            ll.addView(row,i);
        }
    }
}
