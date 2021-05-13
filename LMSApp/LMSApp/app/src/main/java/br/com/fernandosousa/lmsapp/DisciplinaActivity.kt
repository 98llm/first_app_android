package br.com.fernandosousa.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_disciplina.*

class DisciplinaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_disciplina)

        salvar.setOnClickListener {
            val textoNome = nome.text.toString()
            val textoProfessor = professor.text.toString()
            val textoImagem = imagem.text.toString()
            val textoEmenta = ementa.text.toString()

            val d = Disciplina()
            d.nome = textoNome
            d.professor = textoProfessor
            d.foto = textoImagem
            d.ementa = textoEmenta

            Thread {
                DisciplinaService.saveDisciplinaDB(d)
                runOnUiThread {
                    finish()
                }
            }.start()
        }
    }

}