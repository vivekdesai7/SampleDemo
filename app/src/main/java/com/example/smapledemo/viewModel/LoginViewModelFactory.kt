package com.example.smapledemo.viewModel

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.example.smapledemo.Interface.LoginResultCallBack

class LoginViewModelFactory(private val listener:LoginResultCallBack): ViewModelProvider.NewInstanceFactory(){
    override  fun <T : ViewModel?> create(modelClass : Class<T>):T{
        return LoginViewModel(listener) as T
    }
}