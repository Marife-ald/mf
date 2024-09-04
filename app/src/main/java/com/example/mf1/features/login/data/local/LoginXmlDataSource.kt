package com.example.mf1.features.login.data.local

import android.content.Context

class LoginXmlDataSource (private val context: Context){
    val sharedPref = context.getSharedPreferences("username",Context.MODE_PRIVATE)
    fun saveUsername(userName : String) {
        val editor  = sharedPref.edit()
        editor.putString("username",userName)
        editor.commit()
    }
}