package com.faizzakiramadhan_19104075.myapplication.ui.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.faizzakiramadhan_19104075.myapplication.MainActivity
import com.faizzakiramadhan_19104075.myapplication.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val btnLogin: Button = findViewById(R.id.btn_login)

        btnLogin.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                startActivity(Intent(this@LoginActivity, MainActivity::class.java))
                finish()
            }
        })
    }
}