package com.example.rodrigotaboadaexamen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.rodrigotaboadaexamen.Adapter.AdapterQuiz
import com.example.rodrigotaboadaexamen.Data.ListQuiz
import com.example.rodrigotaboadaexamen.databinding.ActivtyRecyclerBinding

class RecyclerActivity  : AppCompatActivity(){
    private lateinit var binding : ActivtyRecyclerBinding
    private var quiz = ListQuiz()

    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivtyRecyclerBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        supportActionBar?.setTitle(R.string.txt_recycler)

        loadStudents()
    }

    fun loadStudents(){
        var list = quiz.getEntityQuizArrayList()

        val adapter = AdapterQuiz(list, this@RecyclerActivity, quiz)

        val linearLayout = LinearLayoutManager(this@RecyclerActivity, LinearLayoutManager.VERTICAL,
                false)
        binding.rQuiz.layoutManager = linearLayout
        binding.rQuiz.adapter = adapter

    }

    override fun onRestart() {
        super.onRestart()
        loadStudents()
    }
}