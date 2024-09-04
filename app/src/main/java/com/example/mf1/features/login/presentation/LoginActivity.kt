package com.example.mf1.features.login.presentation

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import com.example.mf1.R
import com.example.mf1.features.login.LoginFactory
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {
    private lateinit var  loginFactory: LoginFactory
    private lateinit var  loginViewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        loginFactory = LoginFactory()
        loginViewModel = loginFactory.provideLoginViewModel()
        setContentView(R.layout.activity_login)
        setupview()
        }
    private fun setupview() {
        val actionValidate = findViewById<Button>(R.id.action_validate)
        actionValidate.setOnClickListener {
           val userName=findViewById<EditText>(R.id.input_user).text.toString()
            val pass=findViewById<EditText>(R.id.input_password).text.toString()
            val isValid = loginViewModel.validateClicked(userName,pass)
            if (isValid) {
                Snackbar.make(
                    findViewById(R.id.main),
                    R.string.mensaje_login_ok,
                    Snackbar.LENGTH_SHORT
                ).show()
            } else {
                Snackbar.make(
                    findViewById(R.id.main),
                    R.string.mensaje_login_mal,
                    Snackbar.LENGTH_SHORT
                ).show()
            }
            loginViewModel.validateClicked(userName,pass)
        }
    }
}