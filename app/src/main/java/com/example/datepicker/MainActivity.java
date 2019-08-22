package com.example.datepicker;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    Button btn;
    DatePickerDialog.OnDateSetListener dateListner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn =findViewById(R.id.date);
        btn.setOnClickListener(new View.OnClickListener() {
            //@RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                Calendar calender = Calendar.getInstance();
                int year = calender.get(calender.YEAR);
                int month = calender.get(calender.MONTH);
                int day = calender.get(calender.DAY_OF_MONTH);

                DatePickerDialog datepickerdialog = new DatePickerDialog(MainActivity.this,android.R.style.Theme_Holo_Dialog_MinWidth,dateListner,year,month,day);

                //datepickerdialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));


                datepickerdialog.show();

            }
        });

        dateListner = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int dayofmonth) {

                //month++;

                String date = year + "/" + month + "/" + dayofmonth;

                btn.setText(date);


            }
        };
    }
}
