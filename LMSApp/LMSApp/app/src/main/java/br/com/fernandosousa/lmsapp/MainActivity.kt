        package br.com.fernandosousa.lmsapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.login_constraint.*


class MainActivity : DebugActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_constraint)

        imagem_login.setImageResource(R.drawable.imagem_login)

        campo_usuario.setText(Prefs.getString("nome_usuario"))
        campo_senha.setText(Prefs.getString("senha"))
        checkLogin.isChecked = Prefs.getBoolean("check_login")



        val context: Context = this
        botao_login.setOnClickListener {
            Handler(Looper.getMainLooper()).postDelayed({
                val nome_usuario = campo_usuario.text.toString()
                val senha = campo_senha.text.toString()
                val check_login = checkLogin.isChecked

                botao_login.setText("")
                progress_login.visibility = View.VISIBLE

                if (validate_login(nome_usuario,senha)){

                    if (check_login) {
                        Prefs.setString("nome_usuario", nome_usuario)
                        Prefs.setString("senha", senha)
                    } else {
                        Prefs.setString("nome_usuario", "")
                        Prefs.setString("senha", "")
                    }
                    Prefs.setBoolean("check_login", check_login)

                    val intent = Intent(context, TelaInicialActivity::class.java)
                    val params = Bundle()
                    params.putString("nome", nome_usuario)

                    intent.putExtras(params)

                    startActivity(intent)
                }
            }, 2000)
            Toast.makeText(this, "Clicou no botão de login", Toast.LENGTH_SHORT).show()
            // qualquer outra coisa que o evento de clique deve executar

        }




    }

    fun validate_login(usuario:String, senha:String):Boolean{
        if ((usuario == "aluno") && (senha == "impacta")){
            return true
        }else{
            return false
        }
    }

    override fun onResume() {
        super.onResume()
        botao_login.setText("Login")
        progress_login.visibility = View.GONE
    }

}