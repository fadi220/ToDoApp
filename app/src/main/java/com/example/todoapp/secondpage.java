package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class secondpage extends AppCompatActivity {
    TextView tvv1, tvv2, tvadditem, tvAdd, tvPriority, tvDate1, tvDate2, tvTimePick, tvTime, tvRepeat;
    EditText ename;
    ImageView addpic, pic2, calpic, clockpic, repeatpic;
    CheckBox btnHigh, btnMedium, btnLow;
    Button btnSave;
    DatePickerDialog.OnDateSetListener setListener;
    int t1Hour , t1Minute ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondpage);
        clockpic = findViewById(R.id.clockpic);
        clockpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        secondpage.this, android.R.style.Theme_DeviceDefault_Light_Dialog_NoActionBar_MinWidth,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                t1Hour = hourOfDay;
                                t1Minute = minute;
                                String time = t1Hour + ":" + t1Minute;
                                SimpleDateFormat f24Hours = new SimpleDateFormat(
                                        "HH:mm"
                                );
                                try {
                                    Date date = f24Hours.parse(time);
                                    SimpleDateFormat f12Hours = new SimpleDateFormat(
                                            "hh:mm aa"
                                    );
                                    tvTime.setText(f12Hours.format(date));
                                } catch (ParseException e) {
                                    e.printStackTrace();
                                }
                            }
                        }, 12, 0, false);
                timePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                timePickerDialog.updateTime(t1Hour, t1Minute);
                timePickerDialog.show();
            }

        });
        calpic = findViewById(R.id.calpic);
        Calendar calendar = Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        calpic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        secondpage.this, android.R.style.TextAppearance_Holo_Large_Inverse,
                        setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();

            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = day+"/"+month+"/"+year;
                tvDate2.setText(date);
            }
        };
    }
    private void init(){
        tvv1 = findViewById(R.id.tvv1);
        tvv2 = findViewById(R.id.tvv2);
        tvadditem = findViewById(R.id.tvadditem);
        tvAdd = findViewById(R.id.tvAdd);
        tvPriority = findViewById(R.id.tvPriority);
        tvDate1 = findViewById(R.id.tvDate1);
        tvDate2 = findViewById(R.id.tvDate2);
        tvTimePick = findViewById(R.id.tvTimePick);
        tvTime = findViewById(R.id.tvTime);
        tvRepeat = findViewById(R.id.tvRepeat);
        ename = findViewById(R.id.ename);
        addpic = findViewById(R.id.addpic);

        repeatpic = findViewById(R.id.repeatpic);
        btnHigh = findViewById(R.id.btnHigh);
        btnMedium = findViewById(R.id.btnMedium);
        btnLow = findViewById(R.id.btnLow);
        btnSave = findViewById(R.id.btnSave);

}
}