package com.example.rodrigotaboadaexamen

import android.content.Intent
import android.os.Bundle
import android.provider.SyncStateContract
import android.provider.SyncStateContract.Constants
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.rodrigotaboadaexamen.Data.ListQuiz
import com.example.rodrigotaboadaexamen.Data.ListUsers
import com.example.rodrigotaboadaexamen.databinding.ActivityHomeBinding
import com.example.rodrigotaboadaexamen.databinding.ActivityRegisterBinding

class HomeActivity: AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val listQuiz= ListQuiz()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setTitle((R.string.text_Home))

        var email: String? =intent.getStringExtra("email")
        if(email==null){
            email=""
        }
        val adapter = ArrayAdapter<String>(this@HomeActivity,android.R.layout.simple_list_item_1,listQuiz.getStringArrayQuiz())
        binding.listQuiz.adapter = adapter

        binding.listQuiz.setOnItemClickListener { adapterView: AdapterView<*>, view1: View, position: Int, id: Long ->
            var id:Int =binding.listQuiz.selectedItemPosition
            val builder = AlertDialog.Builder(this)
            builder.setTitle("¿Que quieres hacer?")
            builder.setPositiveButton("Editar") { dialog, which ->
                /*val selectedItem = adapterView.getItemAtPosition(position)

                Toast.makeText(this@ListEditDeleteActivity, "$position $id $selectedItem", Toast.LENGTH_SHORT).show()

                val intent = Intent(this@ListEditDeleteActivity, EditActivity::class.java).apply {

                    putExtra(Constants.ID, position)
                }*/

                val intent=Intent(this@HomeActivity,EditActivity::class.java)
                startActivity(intent)
            }

            builder.setNegativeButton("Eliminar") { dialog, which ->
                listQuiz.delete(id)
            }
            builder.setNeutralButton ("Ver") { dialog, which ->
                val intent = Intent(this@HomeActivity, DetailActivity::class.java).apply {
                    putExtra(Constants._ID,position)
                }
                startActivity(intent)
            }


            builder.show()

        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_form_2, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {
            R.id.itmNew -> {
                var email: String? =intent.getStringExtra("email")
                val intent = Intent(this@HomeActivity, SurveyActivity::class.java)
                intent.putExtra("email", email)

                startActivity(intent)
            }
            R.id.itmRecycle->{
                val intent = Intent(this@HomeActivity, RecyclerActivity::class.java)
                startActivity(intent)
            }

        }
        return super.onOptionsItemSelected(item)
    }


}