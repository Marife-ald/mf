package com.example.mf1.features.login.data.remote

class LoginMockRemoteDataSource {
    private val userName= "android"
    private val pass= "12345"
    fun validate (userName: String,pass: String): Boolean {
        return ((this.userName == userName) && (this.pass == pass))
    }
}