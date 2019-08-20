package com.example.smapledemo.Model

import android.databinding.BaseObservable
import android.text.TextUtils
import android.util.Patterns



class User(private var email: String, private var password: String):BaseObservable() {
    val isDataValid:Boolean
        get() = (getEmail().length>1
                && getPassword().length > 6)


    fun getPassword(): String {
        return  password
    }

    fun getEmail() :String{
        return email
    }

    fun setEmail(email: String){
        this.email = email;
    }

    fun setPassword(password: String){
        this.password = password;
    }
}


