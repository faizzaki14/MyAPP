//package com.faizzakiramadhan_19104075.myapplication
//
//import androidx.appcompat.app.AppCompatActivity
//import android.os.Bundle
//import com.faizzakiramadhan_19104075.myapplication.R
//import androidx.viewpager2.widget.ViewPager2
//import com.faizzakiramadhan_19104075.myapplication.Food
//import com.faizzakiramadhan_19104075.myapplication.FoodLocationAdapter
//import java.util.ArrayList
//
//class Main : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//
//        val navcard = findViewById<ViewPager2>(R.id.nav_card)
//        val foodList: MutableList<Food> = ArrayList()
//        val foodBubur = Food()
//
//        foodBubur.imageUrl =
//            "https://raw.githubusercontent.com/faizzaki14/MyAPP/main/Home/assets/Bubur_Ayam-removebg-preview.png"
//        foodBubur.title = "Bubur Ayam"
//        foodBubur.harga = "Merci"
//        foodBubur.starRating = 4.5f
//        foodList.add(foodBubur)
//
//        val foodAyamBakar = Food()
//        foodAyamBakar.imageUrl =
//            "https://raw.githubusercontent.com/faizzaki14/MyAPP/main/Home/assets/Ayam_Sambal-removebg-preview.png"
//        foodAyamBakar.title = "Ayam Bakar"
//        foodAyamBakar.harga = "Merci"
//        foodAyamBakar.starRating = 4.5f
//        foodList.add(foodAyamBakar)
//
//        val CahKangkung = Food()
//        CahKangkung.imageUrl =
//            "https://raw.githubusercontent.com/faizzaki14/MyAPP/main/Home/assets/Cah_Kangkung-removebg-preview.png"
//        CahKangkung.title = "Cah Kangkung"
//        CahKangkung.harga = "Merci"
//        CahKangkung.starRating = 4.5f
//        foodList.add(CahKangkung)
//
//        val NasiUduk = Food()
//        NasiUduk.imageUrl =
//            "https://raw.githubusercontent.com/faizzaki14/MyAPP/main/Home/assets/Nasi_Uduk-removebg-preview.png"
//        NasiUduk.title = "Nasi Uduk"
//        NasiUduk.harga = "Merci"
//        NasiUduk.starRating = 4.5f
//        foodList.add(NasiUduk)
//
//        val Soto = Food()
//        Soto.imageUrl =
//            "https://raw.githubusercontent.com/faizzaki14/MyAPP/main/Home/assets/Soto-removebg-preview.png"
//        Soto.title = "Soto"
//        Soto.harga = "Merci"
//        Soto.starRating = 4.5f
//        foodList.add(Soto)
//        navcard.adapter = FoodLocationAdapter(foodList)
//    }
//}