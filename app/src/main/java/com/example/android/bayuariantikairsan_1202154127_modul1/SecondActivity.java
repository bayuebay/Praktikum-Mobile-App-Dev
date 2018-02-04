package com.example.android.bayuariantikairsan_1202154127_modul1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent intent = getIntent();
        String place = intent.getStringExtra("place");
        String menu = intent.getStringExtra("menu");
        int porsi = intent.getIntExtra("porsi",0);
        int total = intent.getIntExtra("total",0);

        TextView textView = (TextView) findViewById(R.id.output_menu);
        TextView textView2 = (TextView) findViewById(R.id.output_porsi);
        TextView textView3 = (TextView) findViewById(R.id.output_harga);
        TextView textView4 = (TextView) findViewById(R.id.textView2);

        textView.setText(menu);
        textView2.setText(String.valueOf(porsi));
        textView3.setText(String.valueOf(total));
        textView4.setText(place);
        if (total<=65500) {
            Toast toast = Toast.makeText(this, place+" murah nih, Mending disini aja", Toast.LENGTH_LONG);
            toast.show();
        }else {
            Toast toast = Toast.makeText(this, "di "+place+" kemahalan, duit tak cukup", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
