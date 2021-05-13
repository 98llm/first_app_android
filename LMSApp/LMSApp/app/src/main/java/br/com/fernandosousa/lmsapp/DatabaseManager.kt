package br.com.fernandosousa.lmsapp

import androidx.room.Room

object DatabaseManager {
    private var dbInstance: LMSDatabase

    init {
        val context = LMSApplication.getInstance().applicationContext
        dbInstance = Room.databaseBuilder(
            context,
            LMSDatabase::class.java,
            "lms.sqlite"
        ).build()
    }

    fun getDisciplinaDAO(): DisciplinaDAO {
        return dbInstance.disciplinaDAO()
    }
}