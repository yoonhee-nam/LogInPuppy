package com.example.myfirstapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class SignUpActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

       val baby = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
           result ->
           if (result.resultCode == RESULT_OK){
               val data: Intent? = result.data
               val signUpId = data?. getStringExtra("dataFromSignUpActivityId")
               val signUpPass = data?.getStringExtra("dataFromSignUpActivityPass")
           }
       }
        // 이제 signUpId와 signUpPass 변수에 데이터가 들어있음

        val sign_up_id = findViewById<EditText>(R.id.editTextText3)
        val sign_up_name = findViewById<EditText>(R.id.editTextText2)
        val sign_up_pass = findViewById<EditText>(R.id.editTextText4)

        val btn = findViewById<Button>(R.id.btnSignUp)
        btn.setOnClickListener {
            val signUpId = sign_up_id.text.toString()
            val signUpName = sign_up_name.text.toString()
            val signUpPass = sign_up_pass.text.toString()

            if (signUpId.isNotEmpty() && signUpName.isNotEmpty() && signUpPass.isNotEmpty()) {

                val intent = Intent(this, SignInActivity::class.java)
                intent.putExtra("dataFromSignUpActivity",signUpId)
                intent.putExtra("dataFromSignUpActivity",signUpPass)
                baby.launch(intent)
                finish()

            } else {
                Toast.makeText(this, "아이디, 비밀번호를 확인하세요", Toast.LENGTH_SHORT).show()
            }

        }
    }
}