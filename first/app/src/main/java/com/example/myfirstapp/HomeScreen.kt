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
import androidx.appcompat.widget.SearchView
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home_screen.*
import kotlinx.android.synthetic.main.toolbar.*



class HomeScreen : AppCompatActivity(),  NavigationView.OnNavigationItemSelectedListener  {
    private val context: Context get() = this

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

        configuraMenuLateral()

        recyclerDisciplinas?.layoutManager = LinearLayoutManager(context)
        recyclerDisciplinas?.itemAnimator = DefaultItemAnimator()
        recyclerDisciplinas?.setHasFixedSize(true)
    }

    private fun configuraMenuLateral() {
        // ícone de menu (hamburger) para mostrar o menu
        var toogle = ActionBarDrawerToggle(this, layoutMenuLateral, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)


        layoutMenuLateral.addDrawerListener(toogle)
        toogle.syncState()

        menu_lateral_view.setNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_disciplinas -> {
                Toast.makeText(this, "Clicou Disciplinas", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_forum -> {
                Toast.makeText(this, "Clicou Forum", Toast.LENGTH_SHORT).show()
            }

            R.id.nav_localizacao -> {
                Toast.makeText(this, "Clicou Localização", Toast.LENGTH_SHORT).show()
            }

        }

        // fecha menu depois de tratar o evento
        layoutMenuLateral.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // infla o menu com os botões da ActionBar
        menuInflater.inflate(R.menu.menu_main, menu)
        // vincular evento de buscar
        (menu?.findItem(R.id.search)?.actionView as SearchView).setOnQueryTextListener(object : SearchView.OnQueryTextListener {

            override fun onQueryTextChange(newText: String): Boolean {
                // ação enquanto está digitando
                return false
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                // ação  quando terminou de buscar e enviou
                return false
            }

        })
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