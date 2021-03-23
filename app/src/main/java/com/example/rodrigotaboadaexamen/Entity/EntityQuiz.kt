package com.example.rodrigotaboadaexamen.Entity

data class EntityQuiz(
    var Name: String,
    var Lastname:String,
    var Edad: String,
    var gender:Int,
    var bodytype:String,
    var muscle:Boolean,
    var Resistence:Boolean,
    var tone:Boolean,
    var pay:Boolean,
    var email:String,
    var id:Int
)
{
    constructor():this("","","",0,"",false,false,false, false,"", 0)

}
