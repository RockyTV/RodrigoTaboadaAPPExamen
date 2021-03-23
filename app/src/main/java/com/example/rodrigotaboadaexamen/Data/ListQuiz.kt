package com.example.rodrigotaboadaexamen.Data

import com.example.rodrigotaboadaexamen.Entity.EntityQuiz
import com.example.rodrigotaboadaexamen.Entity.EntityUser

class ListQuiz {
    companion object{
        private val listQuiz= arrayListOf<EntityQuiz>()
    }
    fun add(quiz: EntityQuiz):Int{
        listQuiz.add(quiz)
        var answer= listQuiz.size-1
        return answer
    }
    fun deleteQuiz(position: Int): Boolean {
        var answer: Boolean = false
        if(position < listQuiz.size){
            listQuiz.removeAt(position)
            answer = true
        }
        return  answer
    }
    fun existsQuiz(id: Int): Int {
        var answer: Int=-1
        var count: Int=-1
        for(element in listQuiz){
            count=count+1
            if(element.id == id){
                answer = count
                break
            }
        }
        return answer
    }


    fun getStringArrayQuiz():Array<String>{
        val answerList= arrayListOf<String>()
        for((index, item) in listQuiz.withIndex()){
            if(item.gender.equals(2)) {
                answerList.add(("${item.id} ${item.Edad} ${item.pay} ${item.bodytype} Masculino"))
            }
            if(item.gender.equals(1)) {
                answerList.add(("${item.id} ${item.Edad} ${item.pay} ${item.bodytype} Femenino"))
            }
        }
        return answerList.toTypedArray()
    }
    fun getQuiz(id:Int):EntityQuiz{
        return listQuiz[id]
    }

    fun delete(id: Int):Boolean{
        var answer:Boolean=false
        for((index,item) in  listQuiz.withIndex()){
            if(item.id==id){
                listQuiz.removeAt(index)
                answer=true
                break
            }
        }
        return answer

    }
    fun sizeQuiz():Int{
        return listQuiz.size
    }
    fun getEntityQuizArrayList():ArrayList<EntityQuiz>{
        return listQuiz
    }

    fun edit(quiz: EntityQuiz, position:Int, originName: String): Int{
        var answer: Int = 0
        if(quiz.Name == originName || !existsName(quiz.Name)){
            if(position < listQuiz.size){
                listQuiz[position] = quiz
                answer = position
            }
        }else{
            answer = -1
        }

        return  answer
    }
    fun existsName(name:String): Boolean {
        var answer: Boolean = false
        for(element in listQuiz){
            if(element.Name == name){
                answer = true
                break
            }
        }
        return answer
    }

}