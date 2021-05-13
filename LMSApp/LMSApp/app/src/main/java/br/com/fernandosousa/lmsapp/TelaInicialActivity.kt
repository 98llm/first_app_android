package br.com.fernandosousa.lmsapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AlertDialog
import androidx.core.view.GravityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.toolbar.*


class TelaInicialActivity : DebugActivity(), NavigationView.OnNavigationItemSelectedListener {

    private val context: Context get() = this
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tela_inicial)

        var params = intent.extras
        val nome = params?.getString("nome")
        Toast.makeText(this, "Nome do usuário $nome", Toast.LENGTH_LONG).show()
        var numero = params?.getInt("numero")

        val nomeShared = Prefs.getString("nomedousuario")
        Toast.makeText(this, "Valor em SharedPreferences: $nomeShared", Toast.LENGTH_SHORT).show()

        setSupportActionBar(toolbar)

        supportActionBar?.title = "Disciplinas"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        configuraMenuLateral()

        recycler_disciplinas?.layoutManager = LinearLayoutManager(this)

    }
    private var disciplinas = listOf<Disciplina>()

    override fun onResume() {
        super.onResume()
        Thread {
            disciplinas = DisciplinaService.getDisciplinasDB()

            runOnUiThread {
                recycler_disciplinas?.adapter = DisciplinaAdapter(disciplinas) {
                    onClickDisciplina(it)
                }
            }
        }.start()
    }

    fun onClickDisciplina(disciplina: Disciplina) {


        val intent = Intent(this, DetalheDisciplinaActivity::class.java)

        intent.putExtra("disciplina", disciplina)

        startActivity(intent)

    }

    private fun configuraMenuLateral() {
        var toogle = ActionBarDrawerToggle(
            this,
            layout_menu_lateral,
            toolbar,
            R.string.nav_open,
            R.string.nav_close
        )

        layout_menu_lateral.addDrawerListener(toogle)
        toogle.syncState()

        nav_menu_lateral.setNavigationItemSelectedListener(this)


    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.nav_disciplinas -> {
                //Toast.makeText(this, "Clicou em Disciplinas", Toast.LENGTH_LONG).show()
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Alerta!")
                builder.setNeutralButton("OK", null)

                val dialog = builder.create()
                dialog.show()
            }
            R.id.nav_forum -> {
                // Navegar para uma nova tela/activity ao clicar no menu de fórum
                val intent = Intent(this, ForumActivity::class.java)
                startActivity(intent)
                //Toast.makeText(this, "Clicou em forum", Toast.LENGTH_LONG).show()
            }
        }
        layout_menu_lateral.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        if (id == R.id.action_buscar) {
            Toast.makeText(context, "Clicou buscar", Toast.LENGTH_SHORT).show()

        } else if (id == R.id.action_atualizar) {
            // logica para mostrar a progress bar e esperar 10 s
            Toast.makeText(this, "Clicou atualizar", Toast.LENGTH_SHORT).show()
        } else if (id == R.id.action_config) {
            Toast.makeText(this, "Clicou config", Toast.LENGTH_SHORT).show()
        } else if(id == android.R.id.home) {
            finish()
        } else if (id ==R.id.action_disciplina) {
            val intent = Intent(this, DisciplinaActivity::class.java)
            startActivity(intent)
        }

        return super.onOptionsItemSelected(item)
    }
}