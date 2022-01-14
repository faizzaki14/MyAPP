package com.faizzakiramadhan_19104075.myapplication.ui.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.faizzakiramadhan_19104075.myapplication.MainActivity
import com.faizzakiramadhan_19104075.myapplication.R
import com.faizzakiramadhan_19104075.myapplication.ui.Register.RegisterActivity
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    lateinit var etEmailLogin: EditText
    private lateinit var etPassLogin: EditText
    lateinit var btnLogin: Button

    // Creating firebaseAuth object
    lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var btnLogin: Button = findViewById(R.id.btn_login)
        val registerLink : TextView = findViewById(R.id.registerLink)
        etEmailLogin = findViewById(R.id.etEmailLogin)
        etPassLogin = findViewById(R.id.etPassLogin)

        // initialising Firebase auth object
        auth = FirebaseAuth.getInstance()

        btnLogin.setOnClickListener {
            login()
        }

        registerLink.setOnClickListener {
           startActivity(Intent(this@LoginActivity, RegisterActivity::class.java))
            finish()
        }
    }

    private fun login() {
        val email = etEmailLogin.text.toString()
        val pass = etPassLogin.text.toString()
        auth.signInWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully LoggedIn", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@LoginActivity, MainActivity::class.java )
                startActivity(intent)
                finish()
            } else
                Toast.makeText(this, "Log In failed ", Toast.LENGTH_SHORT).show()
        }
    }
}