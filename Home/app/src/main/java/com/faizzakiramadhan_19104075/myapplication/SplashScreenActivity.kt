package com.faizzakiramadhan_19104075.myapplication

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.faizzakiramadhan_19104075.myapplication.ui.BroadCastReceiver.InternetBroadcastReceiver
import com.faizzakiramadhan_19104075.myapplication.ui.Login.LoginActivity

class SplashScreenActivity : AppCompatActivity() {

    lateinit var receiver: InternetBroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

        val handler = Handler(mainLooper)
        handler.postDelayed({
            val intent = Intent(this@SplashScreenActivity, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 4000)

        // internet receiver
        receiver = InternetBroadcastReceiver()
        IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION).also {
            registerReceiver(receiver, it)
        }

    }

    override fun onStop() {
        super.onStop()
        unregisterReceiver(receiver)
    }
}