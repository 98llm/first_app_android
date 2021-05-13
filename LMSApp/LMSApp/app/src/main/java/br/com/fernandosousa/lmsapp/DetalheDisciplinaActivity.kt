package br.com.fernandosousa.lmsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detalhe_disciplina.*

class DetalheDisciplinaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detalhe_disciplina)
        val disciplina = intent.extras?.getSerializable("disciplina") as Disciplina

        campoNome.text = disciplina.nome
        campoProfessor.text = disciplina.professor
        campoEmenta.text = disciplina.ementa

        botaoRemover.setOnClickListener {
            Thread {
                DisciplinaService.removeDisciplinaDB(disciplina)
                runOnUiThread {
                    finish()
                }
            }.start()
        }

        Picasso.with(this).load(disciplina.foto).fit().into(campoImagem,
            object: com.squareup.picasso.Callback {
                override fun onSuccess() {
                    TODO("Not yet implemented")
                }

                override fun onError() {
                    Toast.makeText(LMSApplication.getInstance().applicationContext, "Erro", Toast.LENGTH_LONG).show()
                }
            }
        )

        Toast.makeText(this, "Clicou disciplina ${disciplina.nome}", Toast.LENGTH_SHORT).show()
    }
}