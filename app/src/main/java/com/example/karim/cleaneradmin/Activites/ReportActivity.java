package com.example.karim.cleaneradmin.Activites;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.example.karim.cleaneradmin.Adapter.ReportAdapter;
import com.example.karim.cleaneradmin.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportActivity extends AppCompatActivity {

    List<String> dayList,monthList,carModelList,TimeList,fullTime,costList,nameList,carNumberList;
    ListView lv;
    ProgressBar pb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);
        pb=findViewById(R.id.pb);
        lv=findViewById(R.id.lv);
        FirebaseDatabase.getInstance().getReference().child("Sales").addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                SplitData((Map)dataSnapshot.getValue());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
    private void SplitData(Map<String,Object> value) {
        dayList=new ArrayList<>();
        monthList=new ArrayList<>();
        carModelList=new ArrayList<>();
        TimeList=new ArrayList<>();
        fullTime=new ArrayList<>();
        costList=new ArrayList<>();
        nameList=new ArrayList<>();
        carNumberList=new ArrayList<>();
        List<String>outputList=new ArrayList<>();
        for(Map.Entry<String,Object> entry:value.entrySet()){
            Map<String,Object> map=(Map)entry.getValue();
            nameList.add(map.get("carType").toString());
            carNumberList.add(map.get("carNumber").toString());
            costList.add(map.get("cost").toString());
            carModelList.add(map.get("carModel").toString());
            fullTime.add(entry.getKey().toString());

        }
        ReportAdapter adapter=new ReportAdapter(this,carModelList,nameList,carNumberList,costList,fullTime);
//        ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,
//                outputList);
        pb.setVisibility(View.GONE);
        lv.setAdapter(adapter);
    }
}
