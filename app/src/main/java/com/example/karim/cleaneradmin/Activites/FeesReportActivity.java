package com.example.karim.cleaneradmin.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.karim.cleaneradmin.Adapter.FeesAdapter;
import com.example.karim.cleaneradmin.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class FeesReportActivity extends AppCompatActivity {

    class Creat<T> {
        public ArrayList<T> creatList() {
            return new ArrayList<T>();
        }
    }
    List<String> timeList,costList,nameList,dateList;
    private void SplitDate(Map<String,Object>value){

        timeList=new ArrayList<>();
        costList=new ArrayList<>();
        nameList=new ArrayList<>();
        dateList=(new Creat<String>()).creatList();
        for (Map.Entry<String,Object>entry:value.entrySet()){
            Map<String,String>map=(Map)entry.getValue();
            dateList.add(map.get("Date"));
            timeList.add(entry.getKey());
            costList.add(map.get("Cost"));
            nameList.add(map.get("Name"));
        }
        FeesAdapter adapter=new FeesAdapter(this,timeList,costList,nameList,dateList);
        lv.setAdapter(adapter);
    }
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fees_report);
        lv=findViewById(R.id.lv);
        FirebaseDatabase.getInstance().getReference().child("Fees").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                SplitDate((Map)dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
