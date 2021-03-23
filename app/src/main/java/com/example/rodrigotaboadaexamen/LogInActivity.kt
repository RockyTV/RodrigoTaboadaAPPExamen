package com.example.rodrigotaboadaexamen

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.rodrigotaboadaexamen.Data.ListUsers
import com.example.rodrigotaboadaexamen.databinding.ActivityLogInBinding
import com.google.android.material.snackbar.Snackbar

class LogInActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLogInBinding
    private var listUser = ListUsers()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLogInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle((R.string.text_log_in))
        binding.btnAceptar.setOnClickListener(){
            if(binding.textEmail.text.isNotEmpty() && binding.textPassWord.text.isNotEmpty()){

                    var id:Int=listUser.existsEmail(binding.textEmail.text.toString())
                    if(id!=-1) {
                        val user = listUser.getUser(id)
                        if (binding.textPassWord.text.toString().equals(user.password)) {
                            val intent = Intent(this@LogInActivity, HomeActivity::class.java)
                            intent.putExtra("email", binding.textEmail.text.toString())

                            startActivity(intent)

                        }else{
                            Snackbar.make(it, "Contraseña incorrecta", Snackbar.LENGTH_SHORT).show()
                        }
                    }else{
                        Snackbar.make(it, "Email no existe", Snackbar.LENGTH_SHORT).show()
                    }



            }else{
                Snackbar.make(it, "Ingresa email y contraseña", Snackbar.LENGTH_SHORT).show()
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_form, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.itmRegister -> {
                val intent = Intent(this@LogInActivity, RegisterActivity::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }
}