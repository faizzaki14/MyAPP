package com.angger_19104073.rantangku

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       val btnToLogin: Button = findViewById(R.id.btn_login_awal)
       val btnToReg: Button = findViewById(R.id.btn_reg_awal)

        btnToLogin.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            }
        })
        btnToReg.setOnClickListener(object : View.OnClickListener{
            override fun onClick(v: View?) {

                startActivity(Intent(this@MainActivity, RegisterActivity::class.java))
            }
        })

    }

}