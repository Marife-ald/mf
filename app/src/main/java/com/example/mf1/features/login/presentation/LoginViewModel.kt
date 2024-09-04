package com.example.mf1.features.login.presentation

import androidx.lifecycle.ViewModel
import com.example.mf1.features.login.domain.SignUseCase

class LoginViewModel(private val signUseCase: SignUseCase) : ViewModel() {

    fun validateClicked(userName: String, pass: String) : Boolean {
        val isValid = signUseCase.invoke(userName,pass)
        return isValid
    }
}