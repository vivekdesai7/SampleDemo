package com.example.smapledemo.viewModel

import android.arch.lifecycle.ViewModel
import android.text.Editable
import android.text.TextWatcher
import android.util.Base64
import android.util.Log
import android.view.View
import com.example.smapledemo.Interface.LoginResultCallBack
import com.example.smapledemo.Model.NewUser
import com.example.smapledemo.Model.User
import com.example.smapledemo.Model.UserList
import com.example.smapledemo.MyService.RetrofitClientInstance
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


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

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        }
    }


    //Create function to set Pass
    val passwordTextWatcher:TextWatcher
    get() = object:TextWatcher {

        override fun afterTextChanged(s: Editable?) {
            user.setPassword(s.toString())
        }

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

        }

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

        }
    }


    //Create function to process login button onclick
    fun onLoginClicked(v: View){

        if(user.isDataValid) {

            val usr = user.getEmail();
            val pass = user.getPassword()
            val str = usr + ":" + pass

            val auth = " Basic " + Base64.encodeToString(str.toByteArray(), Base64.NO_WRAP)

            RetrofitClientInstance.instance.legsCount(auth).enqueue(object : Callback<ResponseBody> {
                override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
                    Log.e("onFailure", "onFailure"+t.message)
                    listener.onError("Server error")
                }

                override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
                    Log.e("onResponse", "onResponse" + response.code())
                    if(response.code().equals(200)) {
                        listener.onSuccess("Login successfully")
                    }else if(response.code().equals(401)) {
                        listener.onError("Login not valid")
                    }else{
                        listener.onError("Login error")
                    }
                }

            })

        }
    }






}