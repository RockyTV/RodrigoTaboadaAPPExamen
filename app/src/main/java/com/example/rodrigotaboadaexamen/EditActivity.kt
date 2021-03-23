package com.example.rodrigotaboadaexamen

import android.os.Build.ID
import android.os.Bundle
import android.provider.SyncStateContract
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.rodrigotaboadaexamen.Data.ListQuiz
import com.example.rodrigotaboadaexamen.Entity.EntityQuiz
import com.example.rodrigotaboadaexamen.databinding.ActivityEditBinding

class EditActivity:AppCompatActivity() {

    private lateinit var binding: ActivityEditBinding
    private val Quiz = ListQuiz()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityEditBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setTitle(R.string.txt_edit)
        val position:Int = intent.getIntExtra(SyncStateContract.Constants._ID, -1)
        if(position != -1){
            val originQuiz = Quiz.getQuiz(position)
            val quiz = EntityQuiz()

            binding.editName2.setText(originQuiz.Name)
            binding.editLastName2.setText(originQuiz.Lastname)
            binding.edtAge3.setText(originQuiz.Edad)
            binding.spinnerGender2.setSelection(originQuiz.gender)

            when(originQuiz.bodytype){
                "Delgado"->{ binding.rdBody2.check(binding.Delgado2.id) }
                "Medio"->{ binding.rdBody2.check(binding.Medio2.id) }
                "Granse"->{binding.rdBody2.check(binding.Grande2.id) }
            }

            binding.ckMuscle2.isChecked = originQuiz.muscle
            binding.ckResistence2.isChecked = originQuiz.Resistence
            binding.ckTone2.isChecked = originQuiz.tone

            binding.switchPay2.isChecked = originQuiz.pay

            binding.btnOk2.setOnClickListener {
                if(binding.editName2.text.trim().isNotEmpty() && binding.editLastName2.text.trim().isNotEmpty() && binding.rdBody2.checkedRadioButtonId != -1 && binding.spinnerGender2.selectedItemPosition != 0){

                    quiz.Name = binding.editName2.text.toString()
                    quiz.Lastname = binding.editLastName2.text.toString()

                    quiz.gender = binding.spinnerGender2.selectedItemPosition

                    when(binding.rdBody2.checkedRadioButtonId){
                        binding.Delgado2.id -> { quiz.bodytype = "Delgado" }
                        binding.Medio2.id -> { quiz.bodytype = "Medio" }
                        binding.Grande2.id -> { quiz.bodytype = "Grande" }
                    }

                    quiz.muscle = binding.ckMuscle2.isChecked
                    quiz.Resistence = binding.ckResistence2.isChecked
                    quiz.tone = binding.ckTone2.isChecked

                    quiz.pay = binding.switchPay2.isChecked

                    val index = Quiz.edit(quiz, position, originQuiz.Name)
                    if(index >= 0){
                        Toast.makeText(this@EditActivity, "Quiz actualizado", Toast.LENGTH_SHORT).show()
                        finish()
                    }else if(index == -1){
                        Toast.makeText(this@EditActivity, "El nombre no se puede repetir", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this@EditActivity, "Quiz no actualizado", Toast.LENGTH_SHORT).show()
                    }

                }else{
                    Toast.makeText(this@EditActivity, "El nombre, apellidos, género y nivel de objetivos son obligatorios", Toast.LENGTH_SHORT).show()
                }
            }

        }else{
            Toast.makeText(this@EditActivity, "Error al cargar la actividad", Toast.LENGTH_SHORT).show()
            finish()
        }

    }
}