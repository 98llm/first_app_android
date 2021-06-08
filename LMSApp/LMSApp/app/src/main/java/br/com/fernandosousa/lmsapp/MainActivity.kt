        package br.com.fernandosousa.lmsapp

import android.content.Context
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_tela_inicial.*
import kotlinx.android.synthetic.main.login_constraint.*
import okhttp3.*
import java.io.IOException


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
                botao_login.setBackgroundColor(Color.parseColor("#6AE16C"))

                Thread {

                    val usuario = UsuarioService.getUsuarios(nome_usuario)

                    runOnUiThread {
                        if ((nome_usuario == usuario?.nome) && (senha == usuario?.senha)) {

                            if (check_login) {

                                Prefs.setString("nome_usuario", nome_usuario)
                                Prefs.setString("senha", senha)

                            }else {

                                Prefs.setString("nome_usuario", "")
                                Prefs.setString("senha", "")

                            }

                            Prefs.setBoolean("check_login", check_login)

                            val intent = Intent(context, TelaInicialActivity::class.java)
                            val params = Bundle()

                            params.putString("nome", nome_usuario)
                            intent.putExtras(params)
                            startActivity(intent)


                            Toast.makeText(this, "Clicou no botão de login", Toast.LENGTH_SHORT).show()
                            // qualquer outra coisa que o evento de clique deve executar

                        }else{
                            Toast.makeText(this, "Usuario e/ou senha invalido(s)", Toast.LENGTH_SHORT).show()
                            // qualquer outra coisa que o evento de clique deve executar
                        }
                    }
                }.start()

            }, 2000)
        }

}    override fun onResume() {
        super.onResume()
        botao_login.setText("Login")
        botao_login.setBackgroundColor(Color.parseColor("#FF9800"))
        progress_login.visibility = View.GONE
    }
}