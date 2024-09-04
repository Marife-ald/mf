package com.example.mf1.features.login

import android.content.Context
import com.example.mf1.features.login.data.LoginDataRepository
import com.example.mf1.features.login.data.local.LoginXmlDataSource
import com.example.mf1.features.login.data.remote.LoginMockRemoteDataSource
import com.example.mf1.features.login.domain.LoginRepository
import com.example.mf1.features.login.domain.SignUseCase
import com.example.mf1.features.login.presentation.LoginViewModel


class LoginFactory (private val context: Context){
    // Atributos de clase
    private val loginMockRemoteDataSource : LoginMockRemoteDataSource = provideLoginRemoteDataSource()
    private val loginRepository : LoginRepository= provideLoginDataRepository()
    private val signInUseCase : SignUseCase = provideSignUseCase()
    private val loginXmlDataSource : LoginXmlDataSource = provideloginXmlRemoteDataSource()

    // Métodos de clase
    fun provideLoginViewModel(): LoginViewModel {
        return LoginViewModel(signInUseCase)
    }
    private fun provideLoginRemoteDataSource() : LoginMockRemoteDataSource {
        return LoginMockRemoteDataSource()
    }
    private fun provideLoginDataRepository() : LoginDataRepository{
        return LoginDataRepository(loginMockRemoteDataSource,loginXmlDataSource)
    }
    private fun provideSignUseCase(): SignUseCase {
        return SignUseCase(loginRepository)
    }
    private fun provideloginXmlRemoteDataSource(): LoginXmlDataSource {
        return LoginXmlDataSource(context)
    }
}
