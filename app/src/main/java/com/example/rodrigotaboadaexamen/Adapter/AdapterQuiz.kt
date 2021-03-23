package com.example.rodrigotaboadaexamen.Adapter

import android.content.Context
import android.content.Intent
import android.provider.SyncStateContract
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.example.rodrigotaboadaexamen.Data.ListQuiz
import com.example.rodrigotaboadaexamen.DetailActivity
import com.example.rodrigotaboadaexamen.EditActivity
import com.example.rodrigotaboadaexamen.Entity.EntityQuiz
import com.example.rodrigotaboadaexamen.R
import com.example.rodrigotaboadaexamen.databinding.ItemQuizBinding
import com.google.android.material.snackbar.Snackbar

class AdapterQuiz(val listQuiz: ArrayList<EntityQuiz>, val context:Context, val quiz:ListQuiz) : RecyclerView.Adapter<quizHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): quizHolder {
        val inflater = LayoutInflater.from(parent.context)
        return quizHolder(inflater.inflate(R.layout.item_quiz, parent, false))
    }
    override fun getItemCount(): Int {
        return listQuiz.size
    }

    override fun onBindViewHolder(holder: quizHolder, position: Int) {

        holder.FullName.text = "${listQuiz[position].Name} ${listQuiz[position].Lastname}"
        holder.gender.text = "${if (listQuiz[position].gender == 1) "Masculino" else "Femenino"}"
        holder.email.text = "${listQuiz[position].email}"
        if(listQuiz[position].gender == 1){
            holder.logos.setImageResource(R.drawable.komi)
        }else{
            holder.logos.setImageResource(R.drawable.adan)
        }

        holder.btnDelete.setOnClickListener {
            actionDialog(position, it).show()
        }

        holder.btnEdit.setOnClickListener {
            val intent = Intent(context, EditActivity::class.java).apply{
                putExtra(SyncStateContract.Constants._ID, position)
            }
            context.startActivity(intent)
        }

        holder.btnView.setOnClickListener {
            val intent = Intent(context, DetailActivity::class.java).apply{
                putExtra(SyncStateContract.Constants._ID, position)
            }

            context.startActivity(intent)
        }

    }

    fun actionDialog(position: Int, view: View): AlertDialog {
        val alert = AlertDialog.Builder(context)
        alert.setTitle("Examen Primer Periodo")
        alert.setIcon(R.drawable.mi_nave)
        alert.setMessage("¿Realmente deseas eliminar el quiz?")

        alert.setPositiveButton("Sí"){_,_ ->
            if(quiz.deleteQuiz(position)){
                Toast.makeText(context, "Quiz eliminado", Toast.LENGTH_SHORT).show()
                notifyDataSetChanged()
            }else{
                Snackbar.make(view, "Error al eliminar", Snackbar.LENGTH_SHORT).show()
            }
        }

        alert.setNegativeButton("No"){_,_ ->

        }

        return  alert.create()
    }

}
class quizHolder(view: View):RecyclerView.ViewHolder(view){
    val binding=ItemQuizBinding.bind(view)
    val btnView=binding.btnView
    val btnDelete=binding.btnDelete
    val btnEdit=binding.btnEdith
    val FullName=binding.textFullName
    val gender=binding.Gender2
    val email=binding.email2
    val logos=binding.logoId
    
}