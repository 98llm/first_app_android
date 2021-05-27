package br.com.fernandosousa.lmsapp

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object UsuarioService {

    val host = "https://98llm.pythonanywhere.com/"
    val TAG = "WS_Leandro"

    fun getUsuarios(): List<Usuarios> {

        val url = "$host/usuarios"
        val json = HttpHelper.get(url)

        Log.d(TAG, json)

        var usuarios = parserJson<List<Usuarios>>(json)

        return usuarios
    }

    fun getUsuarios(nome: String):Usuarios? {

        val url = "$host/usuarios/$nome"

        val json = HttpHelper.get(url)

        Log.d(TAG, json)

        if (json.equals("Usuario nao existe")){
            return null
        }

        var usuario = parserJson<Usuarios>(json)

        return usuario
    }

    fun saveUsuario(usuario: Usuarios) : String {
        val json = HttpHelper.post("$host/usuarios", usuario.toJson())
        return json
    }

    fun saveUsuarioDB(usuario: Usuarios): String {
        val dao = DatabaseManager.getUsuarioDAO()
        dao.insert(usuario)

        return "OK"
    }

    fun removeUsuarioDB(usuario: Usuarios) {
        val dao = DatabaseManager.getUsuarioDAO()
        dao.delete(usuario)
    }

    inline fun <reified T> parserJson(json: String) : T {
        val type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}