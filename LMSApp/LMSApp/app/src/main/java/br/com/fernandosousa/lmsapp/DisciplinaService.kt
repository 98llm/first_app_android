package br.com.fernandosousa.lmsapp

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.net.URL

object DisciplinaService {

    val host = "https://fesousa.pythonanywhere.com"
    val TAG = "WS_LMSApp"

    fun getDisciplinas(): List<Disciplina> {

        val url = "$host/disciplinas"
        val json = HttpHelper.get(url)

        Log.d(TAG, json)

        var disciplinas = parserJson<List<Disciplina>>(json)

        return disciplinas
    }

    fun getDisciplinasDB(): List<Disciplina> {
        val dao = DatabaseManager.getDisciplinaDAO()
        return dao.findAll()
    }

    fun saveDisciplina(disciplina: Disciplina) : String {
        val json = HttpHelper.post("$host/disciplinas", disciplina.toJson())
        return json
    }

    fun saveDisciplinaDB(disciplina: Disciplina): String {
        val dao = DatabaseManager.getDisciplinaDAO()
        dao.insert(disciplina)

        return "OK"
    }

    fun removeDisciplinaDB(disciplina: Disciplina) {
        val dao = DatabaseManager.getDisciplinaDAO()
        dao.delete(disciplina)
    }



    inline fun <reified T> parserJson(json: String) : T {
        val type = object: TypeToken<T>(){}.type
        return Gson().fromJson<T>(json, type)
    }
}