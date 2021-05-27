package br.com.fernandosousa.lmsapp

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UsuarioDAO {

    @Query("SELECT * FROM usuarios where id = :id")
    fun getById(id: Long): Usuarios?

    @Query("SELECT * FROM usuarios where username = :username")
    fun getByUsername(username: String): Usuarios?

    @Query("SELECT * FROM usuarios")
    fun findAll(): List<Usuarios>

    @Insert
    fun insert(usuario: Usuarios)

    @Delete
    fun delete(usuario: Usuarios)

}