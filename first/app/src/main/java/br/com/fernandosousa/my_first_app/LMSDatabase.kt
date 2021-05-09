package br.com.fernandosousa.my_first_app

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = arrayOf(Disciplina::class), version = 1)
abstract class LMSDatabase:RoomDatabase() {
    abstract fun disciplinaDAO(): DisciplinaDAO

}