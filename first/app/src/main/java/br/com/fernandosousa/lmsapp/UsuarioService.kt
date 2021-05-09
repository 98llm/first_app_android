package br.com.fernandosousa.lmsapp

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object UsuarioService {

    //TROQUE PELA URL DE ONDE ESTÁ O WS
    // Veja um exemplo no repositório https://github.com/fesousa/aula-android-kotlin-api
    val host = "http://98llm.pythonanywhere.com/usuarios"
    val TAG = "WS_98llm"

    fun getUsuarios (context: Context): List<Usuario> {
        if (AndroidUtils.isInternetDisponivel(context)) {
            val url = "${UsuarioService.host}/usuarios"
            val json = HttpHelper.get(url)
            return DisciplinaService.parserJson(json)
        } else {
            return ArrayList<Usuario>()
        }
    }
}