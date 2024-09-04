package com.example.mf1.features.login.domain

interface LoginRepository {
    fun isValid (userName: String, pass: String):Boolean
    fun saveUsername (userName: String)
}