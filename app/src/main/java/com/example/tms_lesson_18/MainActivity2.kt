package com.example.tms_lesson_18

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val text1 = findViewById<TextView>(R.id.textView2)
        val text2 = findViewById<TextView>(R.id.textView3)
        val text3 = findViewById<TextView>(R.id.textView4)
        val text4 = findViewById<TextView>(R.id.textView5)
        val text5 = findViewById<TextView>(R.id.textView6)

        val login = intent.getStringExtra("login")
        val password = intent.getStringExtra("password")
        val news = intent.getStringExtra("news")
        val discount = intent.getStringExtra("discount")
        val cookies = intent.getStringExtra("cookies")

        text1.text = login ?: ""

        text2.text = password ?: ""

        text3.text = news ?: ""

        text4.text = discount ?: ""

        text5.text = cookies ?: ""

    }
}