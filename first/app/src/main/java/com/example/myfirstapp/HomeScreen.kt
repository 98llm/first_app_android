package com.example.myfirstapp

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_display_message)

        // Get the Intent that started this activity and extract the string
        val username = intent.getStringExtra(EXTRA_MESSAGE)

        Toast.makeText(this, "Bem vindo $username", Toast.LENGTH_SHORT).show()
        // Capture the layout's TextView and set the string as its text
        val textView = findViewById<TextView>(R.id.textView2).apply {
            text = username
        }

        supportActionBar?.title = "Inicio"

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.search) {
        } else if (id == R.id.update) {
            Toast.makeText(this, "Clicou atualizar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.settings) {
            Toast.makeText(this, "Clicou config", Toast.LENGTH_SHORT).show()
        } else if(id == R.id.logout) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}