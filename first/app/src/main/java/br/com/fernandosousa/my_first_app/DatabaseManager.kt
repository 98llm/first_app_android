package br.com.fernandosousa.my_first_app

import androidx.room.Room

object DatabaseManager {
    private var dbInstance: LMSDatabase

    init {
        val context = My_first_app.getIntance().applicationContext
        dbInstance = Room.databaseBuilder(
                context,
                LMSDatabase::class.java,
                "lms.sqlite"
        ).build()
    }

    fun getDisciplinaDAO(): DisciplinaDAO{
        return dbInstance.disciplinaDAO()
    }

}