package com.songbook.cognizantcodingchallenge.ui.loginFragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.songbook.cognizantcodingchallenge.util.Constant
import java.util.regex.Pattern

class LoginViewModel : ViewModel() {

    private val _state = MutableLiveData<LoginState>()
    val state: LiveData<LoginState>
        get() = _state

    private lateinit var emailInput: String
    private lateinit var passwordInput: String

    /**
     * Login Form Validation Check
     * **/
    fun allFieldsValid(email: String, password: String): Boolean {

        emailInput = email
        passwordInput = password

        if (emailInput.isEmpty()) {
            _state.value = LoginState.ShowEmailEmptyError
            return false
        } else if (!Pattern.matches(Constant.EMAIL_REGEX, emailInput)) {
            _state.value = LoginState.ShowInvalidEmailError
            return false
        } else {
            _state.value = LoginState.ShowEmailErrorNull
        }

        return if (passwordInput.isEmpty()) {
            _state.value = LoginState.ShowPasswordEmptyError
            false
        } else if (!Pattern.matches(Constant.PASSWORD_REGEX, passwordInput)) {
            _state.value = LoginState.ShowInvalidPasswordError
            false
        } else {
            _state.value = LoginState.ShowPasswordErrorNull
            true
        }

    }

    sealed class LoginState {

        object ShowEmailEmptyError : LoginState()
        object ShowInvalidEmailError : LoginState()
        object ShowPasswordEmptyError : LoginState()
        object ShowInvalidPasswordError : LoginState()
        object ShowEmailErrorNull : LoginState()
        object ShowPasswordErrorNull : LoginState()

    }

}