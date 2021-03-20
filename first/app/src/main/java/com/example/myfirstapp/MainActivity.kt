package com.example.myfirstapp

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.util.Log
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import kotlinx.android.synthetic.main.activity_main.*



const val EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editText = findViewById<EditText>(R.id.edit_user)
        val cardView = findViewById<CardView>(R.id.cardView_login)
        val layout = findViewById<ConstraintLayout>(R.id.constraint_layout_login)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar2)
        val textView = findViewById<TextView>(R.id.textView)
        val intent = Intent(this, HomeScreen::class.java)
        val username = editText.text.toString()
        val editPassword = findViewById<EditText>(R.id.editTextPassword)
        val password = editPassword.text.toString()

        fun buttonActivated() {
            progressBar.visibility = View.VISIBLE
            textView.text = "Aguarde..."
        }

        fun buttonFinished(username: String) {
            layout.setBackgroundColor(cardView.resources.getColor(R.color.green))
            progressBar.visibility = View.GONE
            textView.text = "Pronto!"
            startActivity(intent.).apply {
                putExtra(username)}
        }


        finalButton.setOnClickListener {
            val editPassword = findViewById<EditText>(R.id.editTextPassword)
            val password = editPassword.text.toString()

            if (username == "aluno" && password == "impacta") {

                Handler().postDelayed({

                    // Chama funcao que finaliza o botão
                    buttonFinished(username)
                    //Altera a Activity

                }, 1500)
                // Chama funcao que Ativa o botão
                buttonActivated()

                Handler().postDelayed({

                    this.recreate()

                }, 1700)
            } else {
                Toast.makeText(this, "Usuário ou senha incorretos", Toast.LENGTH_SHORT).show()
            }

        }
    }
}
