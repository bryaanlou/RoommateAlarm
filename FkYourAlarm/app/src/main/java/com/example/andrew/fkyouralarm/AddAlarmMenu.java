package com.example.andrew.fkyouralarm;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import java.util.Calendar;

public class AddAlarmMenu extends AppCompatActivity {

    private Uri ringtoneuri;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(com.example.andrew.fkyouralarm.R.layout.activity_add_alarm_menu);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle("Add Alarm");

        Intent intent = getIntent();
        TextView textView = new TextView(this);
        /*textView.setTextSize(40);
        textView.setText("why hello there");
        */
        ViewGroup layout = (ViewGroup) findViewById(com.example.andrew.fkyouralarm.R.id.activity_add_alarm_menu);
        layout.addView(textView);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        return true;
    }

    public void selectRingtone(View view)
    {
        final Uri currentTone = RingtoneManager.getActualDefaultRingtoneUri(AddAlarmMenu.this, RingtoneManager.TYPE_ALARM);
        Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_ALARM);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "Select Tone");
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, currentTone);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT, false);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, true);
        startActivityForResult(intent, RingtoneManager.TYPE_ALARM);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == 4 && resultCode == -1)
        {
            ringtoneuri = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
            Ringtone r = RingtoneManager.getRingtone(this, ringtoneuri);
            Button b = (Button) findViewById(com.example.andrew.fkyouralarm.R.id.selectRingtoneButton);
            b.setText(r.getTitle(this));
        }
    }

    public void onSundayClick(View view)
    {
        Button b = (Button) findViewById(com.example.andrew.fkyouralarm.R.id.sundayButton);
        b.setSelected(!b.isSelected());
    }

    public void onMondayClick(View view)
    {
        ToggleButton b = (ToggleButton) findViewById(com.example.andrew.fkyouralarm.R.id.mondayButton);
        b.setSelected(!b.isSelected());
    }

    public void onTuesdayClick(View view)
    {
        Button b = (Button) findViewById(com.example.andrew.fkyouralarm.R.id.tuesdayButton);
        b.setSelected(!b.isSelected());
    }

    public void onWednesdayClick(View view)
    {
        Button b = (Button) findViewById(com.example.andrew.fkyouralarm.R.id.wednesdayButton);
        b.setSelected(!b.isSelected());
    }

    public void onThursdayClick(View view)
    {
        Button b = (Button) findViewById(com.example.andrew.fkyouralarm.R.id.thursdayButton);
        b.setSelected(!b.isSelected());
    }

    public void onFridayClick(View view)
    {
        Button b = (Button) findViewById(com.example.andrew.fkyouralarm.R.id.fridayButton);
        b.setSelected(!b.isSelected());
    }

    public void onSaturdayClick(View view)
    {
        Button b = (Button) findViewById(com.example.andrew.fkyouralarm.R.id.saturdayButton);
        b.setSelected(!b.isSelected());
    }

    public void personalButtonClicked(View view)
    {

    }

    public void pairedButtonClicked(View view)
    {

    }

    public boolean finishButton(View view)
    {
        ToggleButton su = (ToggleButton) findViewById(com.example.andrew.fkyouralarm.R.id.sundayButton);
        ToggleButton mo = (ToggleButton) findViewById(com.example.andrew.fkyouralarm.R.id.mondayButton);
        ToggleButton tu = (ToggleButton) findViewById(com.example.andrew.fkyouralarm.R.id.tuesdayButton);
        ToggleButton we = (ToggleButton) findViewById(com.example.andrew.fkyouralarm.R.id.wednesdayButton);
        ToggleButton th = (ToggleButton) findViewById(com.example.andrew.fkyouralarm.R.id.thursdayButton);
        ToggleButton fr = (ToggleButton) findViewById(com.example.andrew.fkyouralarm.R.id.fridayButton);
        ToggleButton sa = (ToggleButton) findViewById(com.example.andrew.fkyouralarm.R.id.saturdayButton);

        if(su.isSelected())
        {
            setAlarm(1);
        }

        if(mo.isSelected())
        {
            setAlarm(2);
        }

        if(tu.isSelected())
        {
            setAlarm(3);
        }

        if(we.isSelected())
        {
            setAlarm(4);
        }

        if(th.isSelected())
        {
            setAlarm(5);
        }

        if(fr.isSelected())
        {
            setAlarm(6);
        }

        if(sa.isSelected())
        {
            setAlarm(7);
        }

        finish();
        return true;
    }

    public void setAlarm(int dayOfWeek)
    {
        TimePicker tp = (TimePicker) findViewById(com.example.andrew.fkyouralarm.R.id.timePicker);
        EditText et = (EditText) findViewById(com.example.andrew.fkyouralarm.R.id.editText2);
        Calendar calendar = Calendar.getInstance();
        int AM_PM;

        // Add this day of the week line to your existing code
        calendar.set(Calendar.DAY_OF_WEEK, dayOfWeek);
        calendar.set(Calendar.HOUR, tp.getCurrentHour());
        calendar.set(Calendar.MINUTE, tp.getCurrentMinute());
        calendar.set(Calendar.SECOND, 0);

        if(tp.getCurrentHour() < 12) {
            AM_PM = 0;
        } else {
            AM_PM = 1;
        }

        calendar.set(Calendar.AM_PM, AM_PM);

        // Get the Alarm Service.
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Long alarmTime = calendar.getTimeInMillis();
        Intent intentAlarm = new Intent(this, AlarmReceiver.class);
        System.out.println(ringtoneuri.toString());
        intentAlarm.putExtra("rturi",ringtoneuri.toString());
        intentAlarm.putExtra("desc",et.getText());
        System.out.println("here");
        PendingIntent pi = PendingIntent.getBroadcast(this, 0, intentAlarm, 0);

        alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, alarmTime, 7 * 24 * 60 * 60 * 1000 , pi);
        Toast.makeText(this, "WHeee" + dayOfWeek, Toast.LENGTH_SHORT).show();
    }
}
