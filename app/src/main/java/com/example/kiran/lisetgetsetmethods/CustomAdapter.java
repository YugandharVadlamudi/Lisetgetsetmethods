package com.example.kiran.lisetgetsetmethods;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Kiran on 03-12-2015.
 */
public class CustomAdapter extends BaseAdapter {
    ArrayList<ListData> listDatas;
    Context context;
    LayoutInflater layoutInflater;

    CustomAdapter(Context context, ArrayList<ListData> mylist) {
        this.listDatas = mylist;
        this.context = context;
//        Log.d("arrraysizeinconstructor",""+listDatas.size());
        /*this line should not be called every time it is object creation purpose up to you had kept in getview method*/
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        Toast.makeText(context,"firstgetcount",Toast.LENGTH_LONG).show();
//        return 0;
        return listDatas.size();
    }

    @Override
    public ListData getItem(int position) {
        Toast.makeText(context,"getitem"+listDatas.get(position),Toast.LENGTH_SHORT).show();
        Log.d("getposition", "" + listDatas.get(position));

        return listDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        Toast.makeText(context,"getItemId",Toast.LENGTH_SHORT).show();

        return listDatas.size();
//        return listDatas.size();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*class refference is created*/
        Toast.makeText(context,"getview",Toast.LENGTH_SHORT).show();

        myHolderClass myHolderClass;

        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.listviewstuff,null,true);
            myHolderClass = new myHolderClass(convertView);
            convertView.setTag(myHolderClass);
            /*Sets the tag associated with this view.*/
        }/*if*/ else {
            myHolderClass = (myHolderClass) convertView.getTag();
        }
        ListData c = getItem(position);
        myHolderClass.textView1.setText(c.getTv_name_1());
        myHolderClass.textView2.setText(c.getTv_name_2());
        myHolderClass.imageView.setImageResource(c.getIm_diaplay());
        return convertView;
    }

    class myHolderClass {
        TextView textView1, textView2;
        ImageView imageView;

        myHolderClass(View view) {
            textView1 = (TextView) view.findViewById(R.id.TV_1);
            textView2 = (TextView) view.findViewById(R.id.TV_2);
            imageView = (ImageView) view.findViewById(R.id.iv);
        }
    }/*myHolderClass*/
}
