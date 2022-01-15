package com.faizzakiramadhan_19104075.myapplication.ui.Register

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
import com.faizzakiramadhan_19104075.myapplication.ui.Login.LoginActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class RegisterActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    lateinit var etEmailReg: EditText
    lateinit var etnama: EditText
    private lateinit var etPassReg: EditText
    private lateinit var btn_register: Button



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val loginLink: TextView = findViewById(R.id.loginLink)
        auth = FirebaseAuth.getInstance()


        etEmailReg = findViewById(R.id.etEmailReg)
        etnama = findViewById(R.id.etNamaReg)
        etPassReg = findViewById(R.id.etPassReg)
        btn_register = findViewById(R.id.btn_register)

        // Initialising auth object
        auth = Firebase.auth

        btn_register.setOnClickListener {
            signUpUser()
        }

        loginLink.setOnClickListener {
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
            finish()
        }
    }


    private fun signUpUser() {
        val email = etEmailReg.text.toString()
        val pass = etPassReg.text.toString()
        val nama = etnama.text.toString()

        // check pass
        if (email.isBlank() || pass.isBlank() || nama.isBlank()) {
            Toast.makeText(this, "Email and Password can't be blank", Toast.LENGTH_SHORT).show()
            return
        }

        auth.createUserWithEmailAndPassword(email, pass).addOnCompleteListener(this) {
            if (it.isSuccessful) {
                Toast.makeText(this, "Successfully Signed Up", Toast.LENGTH_SHORT).show()
                val intent = Intent(this@RegisterActivity, LoginActivity::class.java )
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Signed Up Failed!", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if (auth.currentUser != null){
            Intent(this@RegisterActivity, LoginActivity::class.java).also { intent ->
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
            }

        }
    }

}