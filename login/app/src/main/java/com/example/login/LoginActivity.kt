package com.example.login

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private var dummyName = ""
    private var dummyEmail = ""
    private var dummyPassword = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val etEmail = findViewById<EditText>(R.id.etEmail)
        val etPassword = findViewById<EditText>(R.id.etPassword)
        val btnLogin = findViewById<Button>(R.id.btnLogin)
        val tvRegister = findViewById<TextView>(R.id.tvRegister)

        val registeredName = intent.getStringExtra("USER_NAME")
        val registeredEmail = intent.getStringExtra("USER_EMAIL")
        val registeredPassword = intent.getStringExtra("USER_PASSWORD")

        if (!registeredName.isNullOrEmpty() && !registeredEmail.isNullOrEmpty()) {
            dummyName = registeredName
            dummyEmail = registeredEmail
            dummyPassword = registeredPassword ?: ""
        }

        btnLogin.setOnClickListener {
            val inputEmail = etEmail.text.toString()
            val inputPassword = etPassword.text.toString()

            if (inputEmail == dummyEmail && inputPassword == dummyPassword) {
                val intent = Intent(this, LandingActivity::class.java)
                intent.putExtra("USER_NAME", dummyName)
                startActivity(intent)
                finish()
            } else {
                Toast.makeText(this, "Invalid email or password!", Toast.LENGTH_SHORT).show()
            }
        }

        tvRegister.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }
}
