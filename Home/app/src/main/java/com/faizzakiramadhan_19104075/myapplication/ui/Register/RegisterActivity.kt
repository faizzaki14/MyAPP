package com.faizzakiramadhan_19104075.myapplication.ui.Register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import com.faizzakiramadhan_19104075.myapplication.MainActivity
import com.faizzakiramadhan_19104075.myapplication.R
import com.faizzakiramadhan_19104075.myapplication.ui.Login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnRegister: Button = findViewById(R.id.btn_register)
        val loginLink: TextView = findViewById(R.id.loginLink)

        btnRegister.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                startActivity(Intent(this@RegisterActivity, MainActivity::class.java) )
                finish()
            }
        })

        loginLink.setOnClickListener {
           startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            finish()
        }
    }
}