package br.com.fernandosousa.my_first_app

import android.app.Application
import java.lang.IllegalStateException


class My_first_app : Application() {
    override fun onCreate(){
        super.onCreate()
        appInstance = this
    }

    companion object{
        private var appInstance: My_first_app? = null
        fun getIntance(): My_first_app {
            if(appInstance == null){
                throw IllegalStateException("Configurar apllication no Android Manifest")
            }
            return appInstance!!
        }
    }
}