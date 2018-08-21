package com.example.karim.cleaneradmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.karim.cleaneradmin.Activites.FeesReportActivity;
import com.example.karim.cleaneradmin.Activites.ReportActivity;

public class AllReportActivity extends AppCompatActivity {

    public void feesReport(View view){
        startActivity(new Intent(this, FeesReportActivity.class));
    }
    public void report(View view){
        startActivity(new Intent(this, ReportActivity.class));
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_report);
    }
}
