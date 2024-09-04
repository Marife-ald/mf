package com.example.mf1.features.login.domain

class SignUseCase (private val loginRepository: LoginRepository){
    operator fun invoke(userName : String, pass: String): Boolean {
        return  loginRepository.isValid(userName,pass)
    }
    }