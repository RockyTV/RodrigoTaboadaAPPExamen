package com.example.rodrigotaboadaexamen.Entity

data class EntityUser(
    var email:String,
    var password:String,
    var phone:String,
    var gender: Int
   )
{

    constructor():this("","","",0)


}
