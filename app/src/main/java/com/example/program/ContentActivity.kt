package com.example.program

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ContentActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.content_layout)

        val tvTitle = findViewById<TextView>(R.id.tvTitle)
        val tvContent = findViewById<TextView>(R.id.tvContent)
        val im = findViewById<ImageView>(R.id.im)

        tvTitle.text = intent.getStringExtra("title")
        tvContent.text = intent.getStringExtra("content")

        // Проверка на наличие изображения, чтобы избежать ошибки
        val imageResource = intent.getIntExtra("image", R.drawable.com)
        //im.setImageResource(imageResource)
    }
}
