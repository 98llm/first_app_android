package br.com.fernandosousa.lmsapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable


@Entity(tableName = "usuario")
class Usuario : Serializable {

    @PrimaryKey
    var id:Long = 0
    var nome = ""
    var idade = ""
    var senha = ""

    override fun toString(): String {
        return "Usuario(nome='$nome')"
    }

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }
}