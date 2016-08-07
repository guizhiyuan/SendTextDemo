package com.guizhiyuan.sendtextdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText et_num;
    private TextView et_content;
    private Button btn_send;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_num = (EditText) findViewById(R.id.et_num);
        et_content= (TextView) findViewById(R.id.et_content);
        btn_send= (Button) findViewById(R.id.btn_send);
    }

    public void add(View view) {
        Intent intent = new Intent(this, ContactActivity.class);
        startActivityForResult(intent, 1);
//        startActivity(intent);

    }
    public void template(View view) {
        Intent intent = new Intent(this, SMSTemplateActivity.class);
        startActivityForResult(intent, 2);
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode==10){
            String phone = data.getStringExtra("phone");
            et_num.setText(phone);
        }else if(resultCode==20){
            String sms=data.getStringExtra("sms");
            et_content.setText(sms);
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    public void send(View view) {

        String num=et_num.getText().toString().trim();
        String content=et_content.getText().toString().trim();
        SmsManager smsManager=SmsManager.getDefault();
        ArrayList<String> divideMessage = smsManager.divideMessage(content);
        for (String div:divideMessage) {
            smsManager.sendTextMessage(num,null,div,null,null);
        }
    }

}
