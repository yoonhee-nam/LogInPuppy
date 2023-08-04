package com.example.myfirstapplication

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts

class SignInActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)

        val idData = intent.getStringExtra("dataFromSignUpActivity")
        val idText = findViewById<EditText>(R.id.signInId)
        val passText = findViewById<EditText>(R.id.signInPass)
        idText.setText(idData)
        passText.setText(idData)

        val sign_in_id = findViewById<EditText>(R.id.signInId)

        val sign_in_pass = findViewById<EditText>(R.id.signInPass)


        val btn1 = findViewById<Button>(R.id.btnLogIn)
        btn1.setOnClickListener {
            val signInId = sign_in_id.text.toString()
            val signPass = sign_in_pass.text.toString()

            if (signInId.isNotEmpty() && signPass.isNotEmpty()) {

                val intent = Intent(this, HomeActivity::class.java)
                intent.putExtra("dataFromSignInActivity", signInId)
                startActivity(intent)

            } else {
                Toast.makeText(this, "아이디, 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()
            }
            }
        val btn2 = findViewById<Button>(R.id.btnSignIn)

        btn2.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
        }
    }
}

