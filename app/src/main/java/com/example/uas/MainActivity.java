package com.example.uas;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button pesanApps;
    private Button pesanPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pesanApps = (Button) findViewById(R.id.btn_pesan_apps);
        pesanApps.setOnClickListener(this);

        pesanPhone = (Button) findViewById(R.id.btn_pesan_phone);
        pesanPhone.setOnClickListener(this);
    }
    @Override
    public void onClick(View v){
        switch (v.getId()){
            case R.id.btn_pesan_apps :
                Intent moveIntent = new Intent(MainActivity.this, MenuActivity.class);
                startActivity(moveIntent);
                break;
            case R.id.btn_pesan_phone :
                String phoneNumber = "082128934640";
                Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:"+phoneNumber));
                startActivity(dialPhoneIntent);
                break;
        }
    }
}
