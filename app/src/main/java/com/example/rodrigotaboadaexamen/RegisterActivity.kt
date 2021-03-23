package com.example.rodrigotaboadaexamen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.rodrigotaboadaexamen.Data.ListUsers
import com.example.rodrigotaboadaexamen.Entity.EntityUser
import com.example.rodrigotaboadaexamen.databinding.ActivityLogInBinding
import com.example.rodrigotaboadaexamen.databinding.ActivityRegisterBinding
import com.google.android.material.snackbar.Snackbar

class RegisterActivity:AppCompatActivity() {
    private lateinit var binding: ActivityRegisterBinding

    private var listUser = ListUsers()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle((R.string.text_register))

        binding.buttonRegistrar.setOnClickListener() {
            if (binding.edtEmail.text.isNotEmpty() && binding.editPassword.text.isNotEmpty() && binding.editPhone.text.isNotEmpty()) {
                var existencia: Boolean =
                    listUser.existEmailFilter(binding.edtEmail.text.toString())
                if (existencia != true) {
                    val genderText: String = binding.spinnerGender.selectedItem.toString()
                    if (genderText.equals("Masculino") || genderText.equals("Femenino")) {
                        val user=EntityUser()
                        user.email=binding.edtEmail.text.toString()
                        user.password=binding.editPassword.text.toString()
                        user.phone=binding.editPhone.text.toString()
                        user.gender=binding.spinnerGender.selectedItemPosition
                        val index=listUser.add(user)
                        if(index!=-1){
                            Snackbar.make(it, "Usuario guardado", Snackbar.LENGTH_SHORT).show()
                            binding.editPassword.setText("")
                            binding.editPhone.setText("")
                            binding.edtEmail.setText("")
                        }else{
                            Snackbar.make(it, "Usuario  no guardado", Snackbar.LENGTH_SHORT).show()
                        }

                    }
                } else {
                    Snackbar.make(it, "Este usuario ya existe", Snackbar.LENGTH_SHORT).show()
                }
            } else {
                Snackbar.make(it, "Llena todos los campos", Snackbar.LENGTH_SHORT).show()
            }

        }
    }
    }