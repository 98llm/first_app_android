package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    /** Called when the user taps the Send button */
    fun login(view: View) {
        val editText = findViewById<EditText>(R.id.edit_user)
        val editPassword = findViewById<EditText>(R.id.editTextPassword)
        val password = editPassword.text.toString()
        val username = editText.text.toString()

        if( username == "aluno" && password == "impacta") {
            val intent = Intent(this, HomeScreen::class.java).apply {
                putExtra(EXTRA_MESSAGE, username)
            }
            startActivity(intent)
        } else {
            Toast.makeText(this,"Usuário ou senha incorretos", Toast.LENGTH_SHORT).show()
        }



    }
}