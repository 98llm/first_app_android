package com.example.myfirstapp

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.toolbar.*



class HomeScreen : AppCompatActivity(),  NavigationView.OnNavigationItemSelectedListener  {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)

        // Get the Intent that started this activity and extract the string
        var params = intent.extras
        val username = params?.getString("username")
        Toast.makeText(this, "Bem vindo $username", Toast.LENGTH_LONG).show()

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Diciplinas"

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //configuraMenuLateral()
    }

    private fun configuraMenuLateral() {
        // ícone de menu (hamburger) para mostrar o menu
        var toogle = ActionBarDrawerToggle(

                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close)

        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral_view.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_disciplinas -> {
                //Toast.makeText(this, "Clicou disciplinas", Toast.LENGTH_LONG).show()
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Teste!")
                builder.setNeutralButton("ok", null)
                val dialog = builder.create()
                dialog.show()

            }
            R.id.nav_forum -> {
                Toast.makeText(this, "Clicou Forum", Toast.LENGTH_SHORT).show()
            }
        }

        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
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