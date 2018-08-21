package com.example.karim.cleaneradmin.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.karim.cleaneradmin.Activites.ReportActivity;
import com.example.karim.cleaneradmin.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Karim on 7/31/2018.
 */

public class ReportAdapter extends BaseAdapter {
    Context _ctx;
    List<String> carModelList,  nameList, carNumberList,  costList, fullTime;
    public ReportAdapter(Context _ctx, List<String> carModelList, List<String> nameList, List<String> carNumberList, List<String> costList, List<String> fullTime) {
    this._ctx=_ctx;
    this.carModelList=carModelList;
    this.nameList=nameList;
    this.carNumberList=carNumberList;
    this.costList=costList;
    this.fullTime=fullTime;
    }

    @Override
    public int getCount() {
        return carModelList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View lv;
        LayoutInflater inflater= (LayoutInflater) _ctx.getSystemService(_ctx.LAYOUT_INFLATER_SERVICE);
        if(view==null){
            lv=new View(_ctx);
            lv=inflater.inflate(R.layout.report_item,null);
            ((TextView)lv.findViewById(R.id.carName)).setText(nameList.get(i));
            ((TextView)lv.findViewById(R.id.carModel)).setText(carModelList.get(i));
            ((TextView)lv.findViewById(R.id.carNumber)).setText(carNumberList.get(i));
            ((TextView)lv.findViewById(R.id.date)).setText(fullTime.get(i));
            ((TextView)lv.findViewById(R.id.cost)).setText(costList.get(i));
           // ((TextView)lv.findViewById(R.id.carName)).setText(nameList.get(i));

        }else{
            lv=view;
        }
        return lv;
    }
}
