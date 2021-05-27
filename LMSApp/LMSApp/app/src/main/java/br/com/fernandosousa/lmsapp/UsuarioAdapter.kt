package br.com.fernandosousa.lmsapp

/*
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import java.text.FieldPosition

class UsuarioAdapter (
        val usuarios: List<Usuarios>,
        val onClick: (Usuarios) -> Unit

): RecyclerView.Adapter<UsuarioAdapter.UsuariosViewHolder>() {

    class UsuariosViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val cardNome: TextView
        val cardImage: ImageView
        val cardProgress: ProgressBar
        val cardView: CardView

        init {
            cardNome = view.findViewById(R.id.card_nome)
            cardImage = view.findViewById(R.id.card_image)
            cardProgress = view.findViewById(R.id.card_progress)
            cardView = view.findViewById(R.id.card_disciplinas)
        }
    }

    override fun getItemCount() = this.usuarios.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) : UsuariosViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_disciplina, parent, false)

        val holder = UsuariosViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: UsuariosViewHolder, position: Int) {

        val usuario = usuarios[position]

        holder.cardNome.text = usuarios.nome
        holder.cardProgress.visibility = View.VISIBLE

        val context = holder.itemView.context
        Picasso.with(context).load(usuarios.foto).fit().into(holder.cardImage,
            object: com.squareup.picasso.Callback {
                override fun onSuccess() {
                    holder.cardProgress.visibility = View.GONE
                }
                override fun onError() {
                    //holder.cardImage.setImageResource(R.drawable.imagem_login)
                    holder.cardProgress.visibility = View.GONE
                }
            }
        )

        holder.itemView.setOnClickListener {onClick(usuarios)}

    }

}

 */