package com.example.mf1.features.login.data

import com.example.mf1.features.login.data.local.LoginXmlDataSource
import com.example.mf1.features.login.data.remote.LoginMockRemoteDataSource
import com.example.mf1.features.login.domain.LoginRepository

class LoginDataRepository (
    private val remoteDataSource: LoginMockRemoteDataSource,
    private val localDataSource: LoginXmlDataSource) :
    LoginRepository {
    override fun isValid(userName: String, pass: String): Boolean {
        return remoteDataSource.validate(userName, pass)
    }
    override fun saveUsername(userName: String) {

    }
}