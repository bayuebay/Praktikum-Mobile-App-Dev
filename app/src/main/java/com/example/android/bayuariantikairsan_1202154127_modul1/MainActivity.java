package com.example.android.bayuariantikairsan_1202154127_modul1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText menu;
    private EditText porsi;
    int hargaEatbus = 50000;
    int hargaAbnormal = 30000;
    private static final String LOG_TAG = MainActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = (EditText) findViewById(R.id.editText);
        porsi = (EditText) findViewById(R.id.editText2);
    }

    public void pindah(){
    }

    public void launchEatbus(View view) {
        Intent intent = new Intent(this, SecondActivity.class);
        Context context = getApplicationContext();
        Log.d(LOG_TAG, "Button EatBus clicked!");

        int Porsi = Integer.parseInt(porsi.getText().toString());
        int total = Porsi*hargaEatbus;
        String Menu = menu.getText().toString();
        String Place = "Eatbus";

        intent.putExtra("place",Place);
        intent.putExtra("porsi", Porsi);
        intent.putExtra("total",total);
        intent.putExtra("menu", Menu);
        System.out.println("porsinya"+Porsi);
        if(Menu.equals("Nasi Uduk")&&Porsi==2) {
            startActivity(intent);
        }else {
            Toast toast = Toast.makeText(this, "harus nasi uduk dan dua porsi", Toast.LENGTH_LONG);
            toast.show();
        }

    }

    public void launchAbnormal(View view) {
        Log.d(LOG_TAG, "Button Abnormal clicked!");
        Intent intent = new Intent(this, SecondActivity.class);

        int Porsi = Integer.parseInt(porsi.getText().toString());
        int total = Porsi*hargaAbnormal;
        String Menu = menu.getText().toString();
        String Place = "Abnormal";

        Context context = getApplicationContext();

        intent.putExtra("porsi", Porsi);
        intent.putExtra("total",total);
        intent.putExtra("place",Place);
        intent.putExtra("menu", Menu);

        if(Menu.equals("Nasi Uduk")&&Porsi==2) {
            startActivity(intent);
        }else if(Menu.isEmpty()){
            Toast toast = Toast.makeText(context, "tak boleh kosong", Toast.LENGTH_LONG);
            toast.show();
        }else {
            Toast toast = Toast.makeText(context, "harus nasi uduk dan dua porsi", Toast.LENGTH_LONG);
            toast.show();
        }
    }
}
