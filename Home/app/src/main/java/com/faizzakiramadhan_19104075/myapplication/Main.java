package com.faizzakiramadhan_19104075.myapplication;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import java.util.ArrayList;
import java.util.List;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager2 navcard = findViewById(R.id.nav_card);

        List<Food> foodList = new ArrayList<>();

        Food foodBubur = new Food();
        foodBubur.imageUrl = "https://raw.githubusercontent.com/faizzaki14/MyAPP/main/Home/assets/Bubur_Ayam-removebg-preview.png";
        foodBubur.title = "Bubur Ayam";
        foodBubur.harga = "Merci";
        foodBubur.starRating = 4.5f;
        foodList.add(foodBubur);

        Food foodAyamBakar = new Food();
        foodAyamBakar.imageUrl = "https://raw.githubusercontent.com/faizzaki14/MyAPP/main/Home/assets/Ayam_Sambal-removebg-preview.png";
        foodAyamBakar.title = "Ayam Bakar";
        foodAyamBakar.harga = "Merci";
        foodAyamBakar.starRating = 4.5f;
        foodList.add(foodAyamBakar);

        Food CahKangkung = new Food();
        CahKangkung.imageUrl = "https://raw.githubusercontent.com/faizzaki14/MyAPP/main/Home/assets/Cah_Kangkung-removebg-preview.png";
        CahKangkung.title = "Cah Kangkung";
        CahKangkung.harga = "Merci";
        CahKangkung.starRating = 4.5f;
        foodList.add(CahKangkung);

        Food NasiUduk = new Food();
        NasiUduk.imageUrl = "https://raw.githubusercontent.com/faizzaki14/MyAPP/main/Home/assets/Nasi_Uduk-removebg-preview.png";
        NasiUduk.title = "Nasi Uduk";
        NasiUduk.harga = "Merci";
        NasiUduk.starRating = 4.5f;
        foodList.add(NasiUduk);

        Food Soto = new Food();
        Soto.imageUrl = "https://raw.githubusercontent.com/faizzaki14/MyAPP/main/Home/assets/Soto-removebg-preview.png";
        Soto.title = "Soto";
        Soto.harga = "Merci";
        Soto.starRating = 4.5f;
        foodList.add(Soto);

        navcard.setAdapter(new FoodLocationAdapter(foodList));
    }
}
