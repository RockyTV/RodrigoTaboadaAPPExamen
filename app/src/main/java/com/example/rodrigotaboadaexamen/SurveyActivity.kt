package com.example.rodrigotaboadaexamen

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rodrigotaboadaexamen.Data.ListQuiz
import com.example.rodrigotaboadaexamen.Data.ListUsers
import com.example.rodrigotaboadaexamen.Entity.EntityQuiz

import com.example.rodrigotaboadaexamen.databinding.ActivitySurveyBinding
import com.google.android.material.snackbar.Snackbar

class SurveyActivity:AppCompatActivity() {
    private lateinit var binding: ActivitySurveyBinding
    private var Quiz=ListQuiz()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySurveyBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val quiz=EntityQuiz()
        supportActionBar?.setTitle((R.string.text_quiz))
        binding.btnOk.setOnClickListener(){
            if(binding.editName.text.isNotEmpty()) {
                if(binding.editLastName.text.isNotEmpty()){
                if (binding.edtAge2.text.isNotEmpty()) {
                    var genderr = binding.spinnerGender.selectedItem.toString()
                    if (genderr.equals("Masculino") || genderr.equals("Femenino")) {
                       quiz.Name=binding.editName.text.toString()
                        quiz.Lastname=binding.editLastName.text.toString()
                        quiz.Edad = binding.edtAge2.text.toString()
                        quiz.gender = binding.spinnerGender.selectedItemPosition
                        when (binding.rdBody.checkedRadioButtonId) {
                            binding.Delgado.id -> {
                                quiz.bodytype = "Delgado"
                            }
                            binding.Medio.id -> {
                                quiz.bodytype = "Medio"
                            }
                            binding.Grande.id -> {
                                quiz.bodytype = "Grande"
                            }
                        }
                        quiz.Resistence = binding.ckResistence.isChecked
                        quiz.muscle = binding.ckMuscle.isChecked
                        quiz.tone = binding.ckTone.isChecked
                        quiz.pay = binding.switchPay.isChecked
                        var email: String? = intent.getStringExtra("email")
                        if (email != null) {
                            quiz.email = email
                        }
                        quiz.id = Quiz.sizeQuiz()
                        var id: Int = Quiz.add(quiz)
                        if (id != -1) {
                            Snackbar.make(it, "Quiz guardado", Snackbar.LENGTH_SHORT).show()
                            val intent = Intent(this@SurveyActivity, HomeActivity::class.java)
                            intent.putExtra("email", quiz.email)

                            startActivity(intent)
                        } else {
                            Snackbar.make(it, "Quiz  no guardado", Snackbar.LENGTH_SHORT).show()
                        }

                    } else {
                        Snackbar.make(it, "Selecciona sexo", Snackbar.LENGTH_SHORT).show()
                    }
                } else {
                    Snackbar.make(it, "Pon la edad", Snackbar.LENGTH_SHORT).show()
                }
            }else{
                    Snackbar.make(it, "Pon el apellido", Snackbar.LENGTH_SHORT).show()
                }
            }else{
                Snackbar.make(it, "Pon el nombre", Snackbar.LENGTH_SHORT).show()
            }
        }
}}