package com.example.karim.cleaneradmin.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.karim.cleaneradmin.Activites.FeesReportActivity;
import com.example.karim.cleaneradmin.R;

import org.w3c.dom.Text;

import java.util.List;

/**
 * Created by Karim on 8/1/2018.
 */

public class FeesAdapter extends BaseAdapter {
    Context _ctx;
    List<String> timeList,costList,  nameList,dateList;
    public FeesAdapter(Context _ctx, List<String> timeList, List<String> costList, List<String> nameList,List<String>dateList) {
        this._ctx=_ctx;
        this.timeList=timeList;
        this.nameList=nameList;
        this.costList=costList;
        this.dateList=dateList;
    }
    private  String splitter(String date){
        String nDate="";
        for(int i=date.length()-1 ;i>-1;i--){
            if(date.toCharArray()[i]==',')
                return nDate;
            else
                nDate+=date.toCharArray()[i];

        }
        return nDate;
    }
    @Override
    public int getCount() {
        return timeList.size();
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
        LayoutInflater inflater= (LayoutInflater) _ctx.getSystemService(_ctx.LAYOUT_INFLATER_SERVICE);
        View lv;
        if(view==null){
            lv=new View(_ctx);
            lv=inflater.inflate(R.layout.fees_item,null);
            ((TextView)lv.findViewById(R.id.costType)).setText(nameList.get(i));
            ((TextView)lv.findViewById(R.id.cost)).setText(costList.get(i));
            String date[]=dateList.get(i).split(",");

            String time=timeList.get(i).split("\\s+")[3];
            String day=timeList.get(i).split("\\s+")[2];
            ((TextView)lv.findViewById(R.id.date)).setText(dateList.get(i) +" "+ day);
            ((TextView)lv.findViewById(R.id.day)).setText(date[0]);
            int hh=Integer.parseInt(time.split(":")[0]);
            if(hh>12){
                hh-=12;
                time=String.valueOf(hh)+":"+time.split(":")[1]+":"+time.split(":")[2];
            }
            ((TextView)lv.findViewById(R.id.time)).setText(time);

        }else
            lv=view;
        return lv;
    }
    private String revers(String str){
        char []nStr=new char[str.length()];
        for(int i =1;i<str.length();i++)
            nStr[str.length()-i]=str.toCharArray()[i];
        return nStr.toString();
    }
}
