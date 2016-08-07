package com.guizhiyuan.sendtextdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by guizhiyuan on 2016-08-06.
 */
public class ContactActivity extends AppCompatActivity {

    private ListView mListView;
    private List<Person> lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);
        mListView = (ListView) findViewById(R.id.mListView);
        lists = new ArrayList<Person>();
        for (int i = 0; i < 20; i++) {
            Person p = new Person();
            p.setName("Andy" + i);
            p.setPhone("15" + i);
            lists.add(p);
        }
        mListView.setAdapter(new MyAdapter());
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            String phone=lists.get(position).getPhone();
               Intent intent=new Intent();
                intent.putExtra("phone",phone);
                setResult(10,intent);
                finish();
            }
        });

    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return lists.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view;
            if (convertView == null) {
                view = View.inflate(getApplicationContext(), R.layout.contact_item, null);
            } else {
                view = convertView;
            }
            TextView tv_name = (TextView) view.findViewById(R.id.tv_name);
            TextView tv_phone = (TextView) view.findViewById(R.id.tv_phone);
            tv_name.setText(lists.get(position).getName());
            tv_phone.setText(lists.get(position).getPhone());
            return view;
        }
    }
}
