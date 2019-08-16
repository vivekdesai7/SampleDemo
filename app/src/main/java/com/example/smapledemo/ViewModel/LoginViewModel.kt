package com.example.smapledemo.ViewModel

import android.arch.lifecycle.ViewModel
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import com.example.smapledemo.Interface.LoginResultCallBack
import com.example.smapledemo.Model.User


class LoginViewModel (private val listener: LoginResultCallBack):ViewModel(){
    private val user:User

    init {
        this.user = User(email = "",password = "")
    }


    //Create function to set email
    val emailTextWatcher:TextWatcher
    get() = object:TextWatcher{
        override fun afterTextChanged(s: Editable?) {
            user.setEmail(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }


    //Create function to set Pass
    val passwordTextWatcher:TextWatcher
    get() = object:TextWatcher {

        override fun afterTextChanged(s: Editable?) {
            user.setPassword(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }


    //Create function to process login button onclick
    fun onLoginClicked(v: View){
        if(user.isDataValid)
            listener.onSuccess("Login Sucess")
            else
            listener.onError("Login error")
    }
}