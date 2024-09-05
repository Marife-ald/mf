package com.example.mf1.features.login.presentation

import androidx.lifecycle.ViewModel
import com.example.mf1.features.login.domain.GetUsernameUseCase
import com.example.mf1.features.login.domain.LoginRepository
import com.example.mf1.features.login.domain.SaveUsernameUseCase
import com.example.mf1.features.login.domain.SignUseCase

class LoginViewModel (
    private val signUseCase: SignUseCase,
    private val saveUsernameUseCase: SaveUsernameUseCase,
    private val getUsernameUseCase: GetUsernameUseCase,
    ) : ViewModel() {

        fun validateClicked(userName: String, pass: String,isRemembered : Boolean) :Boolean {
        if (isRemembered) {
            saveUsernameUseCase(userName)
        }
        val isValid = signUseCase.invoke(userName,pass)
        return isValid
    }
    fun onResumed(): String? {
        return getUsernameUseCase.invoke()
        }
    }

