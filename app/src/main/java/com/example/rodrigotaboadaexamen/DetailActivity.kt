package com.example.rodrigotaboadaexamen

import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rodrigotaboadaexamen.Data.ListQuiz
import com.example.rodrigotaboadaexamen.Data.ListUsers
import com.example.rodrigotaboadaexamen.databinding.ActivityDetailBinding
import com.example.rodrigotaboadaexamen.databinding.ActivityLogInBinding

class DetailActivity: AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    private var listQuiz = ListQuiz()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle((R.string.text_detail))
        val id:Int=intent.getIntExtra(SyncStateContract.Constants._ID, -1)
        if (id!=-1)
        {
            val quiz = listQuiz.getQuiz(id)

            binding.textView.text = "${quiz.id}"
            binding.textView2.text = "${  if (quiz.gender==2) "Masculino" else if (quiz.gender==1) "Femenino" else "Genero no seleccionado"} "
            binding.textView3.text = "${quiz.bodytype}"
            binding.textView4.text = "${if(quiz.pay) "Si" else "No"}"
            binding.textView5.text = "Objetivos: ${if(quiz.Resistence)"Resistencia" else ""} ${if(quiz.muscle)"Músculo" else ""} ${if(quiz.tone)"Tonificar" else ""}"


        }
        else
        {
            Toast.makeText(this@DetailActivity,"Se genero un problema al intentar cargar esta pagina", Toast.LENGTH_SHORT).show()
            //finish()
            super.onBackPressed()
        }
}}