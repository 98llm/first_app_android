package br.com.fernandosousa.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class ForumActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forum)

        supportActionBar?.title = "Forum"

    }
}