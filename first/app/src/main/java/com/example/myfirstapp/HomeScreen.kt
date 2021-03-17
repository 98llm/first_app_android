package com.example.myfirstapp

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val username = intent.getStringExtra(EXTRA_MESSAGE)

        //setSupportActionBar(findViewById(R.id.my_toolbar))



        Toast.makeText(this,"Bem vindo $username", Toast.LENGTH_SHORT).show()
        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView2).apply {
            text = username
        }
    }
}