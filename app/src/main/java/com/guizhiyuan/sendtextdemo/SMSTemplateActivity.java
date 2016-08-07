package com.guizhiyuan.sendtextdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.jar.Attributes;

/**
 * Created by guizhiyuan on 2016-08-06.
 */
public class SMSTemplateActivity extends AppCompatActivity {
    private ListView lv_template;
    String objects[] = {"I'am having lunch now, see you later!", "I am in class", "I am in classroom"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_smstemplate);
        lv_template = (ListView) findViewById(R.id.lv_template);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.smstemplate_item, objects);
        lv_template.setAdapter(adapter);
        lv_template.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String sms = objects[position];
                Intent intent = new Intent();
                intent.putExtra("sms", sms);
                setResult(20, intent);
                finish();
            }
        });

    }
}
