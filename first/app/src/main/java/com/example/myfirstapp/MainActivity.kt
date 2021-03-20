package com.example.myfirstapp

import android.content.Context
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

        val cardView = findViewById<CardView>(R.id.cardView_login)
        val layout = findViewById<ConstraintLayout>(R.id.constraint_layout_login)
        val progressBar = findViewById<ProgressBar>(R.id.progressBar2)
        val textView = findViewById<TextView>(R.id.textView)
        val intent = Intent(this, HomeScreen::class.java)



        fun buttonActivated() {
            progressBar.visibility = View.VISIBLE
            textView.text = "Aguarde..."
        }

        fun buttonFinished(username:String) {
            val params = Bundle()
            params.putString("username", username)
            intent.putExtras(params)
            layout.setBackgroundColor(cardView.resources.getColor(R.color.green))
            progressBar.visibility = View.GONE
            textView.text = "Pronto!"
            startActivity(intent)
        }

        finalButton.setOnClickListener {
            val password = editTextPassword.text.toString()
            val username = edit_user.text.toString()

            if (username == "aluno" && password == "impacta") {
                Handler().postDelayed({

                    buttonFinished(username)

                }, 1500)

                buttonActivated()

                Handler().postDelayed({

                    this.recreate()

                }, 1700)
            }
            else {
                Toast.makeText(this, "Usuario ou senha invalido(s)", Toast.LENGTH_SHORT).show()
            }
        }

    }
}

