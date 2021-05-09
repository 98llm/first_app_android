package br.com.fernandosousa.lmsapp

import android.content.SharedPreferences

object Prefs {
    private fun prefs(): SharedPreferences{
        val context = My_first_app.getIntance().applicationContext
        return context.getSharedPreferences("LMS", 0)
    }

    fun setBoolean(flag: String, valor : Boolean){
        prefs().edit().putBoolean(flag,valor).apply()
    }

    fun getBoolean(flag: String): Boolean{
        return prefs().getBoolean(flag, false)
    }

    fun setString(flag: String, valor : String){
        return prefs().edit().putString(flag, valor).apply()
    }

    fun getString(flag: String): String?{
        return prefs().getString(flag,"")
    }
}
