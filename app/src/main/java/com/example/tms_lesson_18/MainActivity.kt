package com.example.tms_lesson_18

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.button)
        val login = findViewById<EditText>(R.id.editTextText)
        val password = findViewById<EditText>(R.id.editTextTextPassword)
        val news = findViewById<RadioButton>(R.id.radioButton1)
        val discount = findViewById<RadioButton>(R.id.radioButton2)
        val cookies = findViewById<RadioButton>(R.id.radioButton3)

        button.isEnabled = false

        button.setOnClickListener {
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("login", login.text.toString())
            intent.putExtra("password", password.text.toString())
            if (news.isChecked) { intent.putExtra("news", news.text.toString()) }
            if (discount.isChecked) { intent.putExtra("discount", discount.text.toString()) }
            if (cookies.isChecked) { intent.putExtra("cookies", cookies.text.toString()) }
            startActivity(intent)
        }

        login.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                button.isEnabled = login.length() >= MIN_LENGTH && password.length() >= MIN_LENGTH
            }
            override fun afterTextChanged(p0: Editable?) {}
        })

        password.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                button.isEnabled = password.length() >= MIN_LENGTH && login.length() >= MIN_LENGTH
            }
            override fun afterTextChanged(p0: Editable?) {}
        })
    }

    companion object {
        private const val MIN_LENGTH = 6
    }
}