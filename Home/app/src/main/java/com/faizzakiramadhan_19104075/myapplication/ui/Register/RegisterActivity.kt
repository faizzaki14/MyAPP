package com.faizzakiramadhan_19104075.myapplication.ui.Register

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.faizzakiramadhan_19104075.myapplication.R
import com.faizzakiramadhan_19104075.myapplication.ui.Login.LoginActivity

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val btnRegister: Button = findViewById(R.id.btn_register)

        btnRegister.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java) )
                finish()
            }
        })
    }
}