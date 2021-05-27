package br.com.fernandosousa.lmsapp

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.GsonBuilder
import java.io.Serializable

@Entity(tableName = "usuarios")
class Usuarios: Serializable {

    @PrimaryKey
    var id: Long? = null
    var nome = ""
    var senha = ""
    var idade = ""
    var username = ""

    fun toJson(): String {
        return GsonBuilder().create().toJson(this)
    }


}