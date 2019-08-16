package com.example.smapledemo.Interface

interface LoginResultCallBack {
    fun onSuccess(message:String)
    fun onError(message: String)
}