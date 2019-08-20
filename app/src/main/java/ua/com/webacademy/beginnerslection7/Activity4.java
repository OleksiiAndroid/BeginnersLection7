package ua.com.webacademy.beginnerslection7;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class Activity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_4);
    }

    public void OnClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        Toast.makeText(Activity4.this, hourOfDay + ":" + minute, Toast.LENGTH_SHORT).show();
                    }
                }, 0, 0, true).show();
                break;
            case R.id.button2:
                new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        Toast.makeText(Activity4.this, dayOfMonth + "." + monthOfYear + 1 + ":" + String.valueOf(year),
                                Toast.LENGTH_SHORT).show();
                    }
                }, 2015, 0, 1).show();
                break;
            case R.id.button3:
                AlertDialog.Builder adb = new AlertDialog.Builder(this);
                adb.setTitle(R.string.alert_title);
                adb.setMessage(R.string.alert_text);
                adb.setIcon(android.R.drawable.ic_dialog_info);
                adb.setPositiveButton(R.string.yes, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Activity4.this, "Button yes clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                adb.setNegativeButton(R.string.no, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Activity4.this, "Button no clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                adb.setNeutralButton(R.string.dont_know, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Activity4.this, "Button neutral clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                adb.create().show();
                break;
            case R.id.button4:
                final ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("Title");
                progressDialog.setMessage("Message");
                progressDialog.setButton(Dialog.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(Activity4.this, "Button clicked", Toast.LENGTH_SHORT).show();
                    }
                });
                progressDialog.show();

                Handler handler = new Handler() {
                    public void handleMessage(Message msg) {
                        progressDialog.dismiss();
                    }
                };
                handler.sendEmptyMessageDelayed(0, 2000);
                break;
        }
    }
}
