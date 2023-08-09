package com.example.myfirstapplication

import android.annotation.SuppressLint
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.util.Random

class HomeActivity : AppCompatActivity() {
    @SuppressLint("WrongViewCast", "MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val imageList = ArrayList<ImageItem>()
        imageList.add(ImageItem(R.drawable.puppy_3))
        imageList.add(ImageItem(R.drawable.puppy_4))
        imageList.add(ImageItem(R.drawable.puppy_5))
        imageList.add(ImageItem(R.drawable.puppy_6))
        imageList.add(ImageItem(R.drawable.puppy_7))

        val random = Random()
        val randomIndex = random.nextInt(imageList.size)// 0부터 리스트 크기 - 1 사이의 랜덤 인덱스 생성
        val randomImageItem = imageList[randomIndex]
        val randomImageResId = randomImageItem.imageResId
        val homeImage = findViewById<ImageView>(R.id.imageView4)
        homeImage.setImageResource(randomImageResId)

        val idData = intent.getStringExtra("dataFromSignInActivity")
        val idText = findViewById<TextView>(R.id.idText)
        idText.setText(idData)


        val btn = findViewById<ConstraintLayout>(R.id.btn)
            btn.setOnClickListener {
            finish()
        }
    }
}

data class ImageItem(val imageResId: Int)