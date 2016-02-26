package com.example.kiran.lisetgetsetmethods;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity {
    ArrayList<ListData> ld=new ArrayList<ListData>();
    ListView lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)findViewById(R.id.lvcustomlistview);
        setData();
        Log.d("arraysize",""+ld.size());
        lv.setAdapter(new CustomAdapter(getApplicationContext(),ld));
    }
    public void setData()
    {
        for(int i=0;i<listdata_strings.name_1.length;i++)
        {
            ListData ld_set_object=new ListData();
            ld_set_object.setTv_name_1(listdata_strings.name_1[i]);
            ld_set_object.setTv_name_2(listdata_strings.name_2[i]);
            ld_set_object.setIm_diaplay(listdata_strings.im[i]);
            ld.add(ld_set_object);
        }/*for*/
    }
}
