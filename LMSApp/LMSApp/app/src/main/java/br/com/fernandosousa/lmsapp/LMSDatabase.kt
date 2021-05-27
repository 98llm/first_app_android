package br.com.fernandosousa.lmsapp

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = arrayOf(Disciplina::class, Usuarios::class), version = 1)
abstract class LMSDatabase: RoomDatabase() {
    abstract fun disciplinaDAO(): DisciplinaDAO
    abstract fun usuarioDAO(): UsuarioDAO
}
