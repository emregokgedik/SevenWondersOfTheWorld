package com.emregokgedik.sevenwondersoftheworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView=findViewById(R.id.listView);

        //Data
        ArrayList<String> wondersNameArray=new ArrayList<>();
        wondersNameArray.add("Great Wall of China");
        wondersNameArray.add("Petra");
        wondersNameArray.add("Christ the Redeemer");
        wondersNameArray.add("Machu Picchu");
        wondersNameArray.add("Chichen Itza");
        wondersNameArray.add("Colosseum");
        wondersNameArray.add("Taj Mahal");
        wondersNameArray.add("Great Pyramid of Giza(honorary candidate)");

        ArrayList<String> wondersCountryArray=new ArrayList<>();
        wondersCountryArray.add("China");
        wondersCountryArray.add("Jordan");
        wondersCountryArray.add("Brazil");
        wondersCountryArray.add("Peru");
        wondersCountryArray.add("Mexico");
        wondersCountryArray.add("Italy");
        wondersCountryArray.add("India");
        wondersCountryArray.add("Egypt");

        Bitmap chinawall= BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.chinawall);
        Bitmap petra=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.petra);
        Bitmap christ=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.christ);
        Bitmap machupicchu=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.machupicchu);
        Bitmap chichenitza=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.chichenitza);
        Bitmap colosseum=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.colosseum);
        Bitmap tajmahal=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.tajmahal);
        Bitmap pyramid=BitmapFactory.decodeResource(getApplicationContext().getResources(),R.drawable.pyramid);

        ArrayList<Bitmap> Images=new ArrayList<>();
        Images.add(chinawall);
        Images.add(petra);
        Images.add(christ);
        Images.add(machupicchu);
        Images.add(chichenitza);
        Images.add(colosseum);
        Images.add(tajmahal);
        Images.add(pyramid);

        //Listview
        ArrayAdapter arrayAdapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,wondersNameArray);

        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent=new Intent(getApplicationContext(),DetailActivity.class);
            intent.putExtra("name",wondersNameArray.get(position));
            intent.putExtra("country",wondersCountryArray.get(position));
            Singleton singleton=Singleton.getInstance();
            singleton.setChosenImage(Images.get(position));

            startActivity(intent);
            }
        });


    }
}