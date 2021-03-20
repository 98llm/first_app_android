package com.example.myfirstapp

import android.content.Context
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
        var params = intent.extras
        val username = params?.getString("username")
        Toast.makeText(this, "Bem vindo $username", Toast.LENGTH_LONG).show()

        findViewById<TextView>(R.id.textView2).apply {
        text = username
        }

        supportActionBar?.title = "Diciplinas"

    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.search -> {

            }
            R.id.update -> {
                this.recreate()
            }
            R.id.settings -> {
                val intent = Intent(this, SettingsActivity::class.java)
                startActivity(intent)
            }
            R.id.logout -> {
                val intent = Intent(this, MainActivity::class.java)
                finish();
                startActivity(intent)
            }
        }

        return super.onOptionsItemSelected(item)
    }
}