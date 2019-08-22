package com.example.smapledemo.MyService

import com.example.smapledemo.Model.NewUser
import com.example.smapledemo.Model.UserList
import com.example.smapledemo.Model.UserModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header

interface LoginService {

    @GET("authorizations")
    fun legsCount(@Header("Authorization")auth:String): Call<ResponseBody>

    @GET("users")
    fun fetchAllUsers():Call<List<UserModel>>
}