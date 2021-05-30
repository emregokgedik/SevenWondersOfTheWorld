package com.emregokgedik.sevenwondersoftheworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    TextView wonderNameText;
    TextView wonderCountryText;
    ImageView wonderImage;
    String wonderName;
    String wonderCountry;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        wonderNameText=findViewById(R.id.wonderNameText);
        wonderCountryText=findViewById(R.id.wonderCountryText);
        wonderImage=findViewById(R.id.wonderImage);
        Intent intent=getIntent();
        wonderName=intent.getStringExtra("name");
        wonderCountry=intent.getStringExtra("country");
        wonderNameText.setText(wonderName);
        wonderCountryText.setText(wonderCountry);

        Singleton singleton=Singleton.getInstance();
        wonderImage.setImageBitmap(singleton.getChosenImage());

    }
}