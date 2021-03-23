package com.example.rodrigotaboadaexamen.Data

import com.example.rodrigotaboadaexamen.Entity.EntityQuiz
import com.example.rodrigotaboadaexamen.Entity.EntityUser

class ListUsers {
    companion object{
        private val listUser= arrayListOf<EntityUser>()

    }
    fun add(user: EntityUser):Int{
        var answer=-1
        if(!existEmailFilter((user.email))){
            listUser.add(user)
            answer=listUser.size-1
        }
        return answer
    }

    fun existEmailFilter(email:String):Boolean{
        var answer:Boolean=false
        if(listUser.filter { e -> e.email==email }.count()==1){
            answer=true
        }
        return answer
    }
    fun getUser(id:Int):EntityUser{
        return listUser[id]
    }
    fun existsEmail(email:String): Int {
        var answer: Int=-1
        var count: Int=-1
        for(element in listUser){
            count=count+1
            if(element.email == email){
                answer = count
                break
            }
        }
        return answer
    }


}