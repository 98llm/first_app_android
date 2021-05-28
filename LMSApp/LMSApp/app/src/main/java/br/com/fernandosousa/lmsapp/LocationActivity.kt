package br.com.fernandosousa.lmsapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle



class LocationActivity :  DebugActivity() {
    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_location)


        supportActionBar?.title = "Localização"




    }

    override fun onResume() {
        super.onResume()
        val mapaFragment = MapaFragment()
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.layoutMapas, mapaFragment)
                .commit()

    }
}