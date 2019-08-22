package com.example.smapledemo.viewModel

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.smapledemo.Model.UserModel
import com.example.smapledemo.MyService.RetrofitClientInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class UserListViewModel : ViewModel {

    var login =""
    var id=""
    var node_id=""
    var avatar_url=""
    var gravatar_id=""
    var url=""
    var html_url=""

    constructor() : super()
    constructor(userModel: UserModel ) : super() {
        this.login = userModel.login
        this.id =userModel. id
        this.node_id = userModel.node_id
        this.avatar_url = userModel.avatar_url
        this.gravatar_id = userModel.gravatar_id
        this.url = userModel.url
        this.html_url = userModel.html_url
    }


    var allayListMutableLivedata = MutableLiveData<ArrayList<UserListViewModel>>()
    var arrayList = ArrayList<UserListViewModel>()

    fun getMutableArraylist(): MutableLiveData<ArrayList<UserListViewModel>> {


        RetrofitClientInstance.instance.fetchAllUsers().enqueue(object : Callback<List<UserModel>> {
            override fun onFailure(call: Call<List<UserModel>>, t: Throwable) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }

            override fun onResponse(call: Call<List<UserModel>>, response: Response<List<UserModel>>) {

                for (i in response.body()!!){
                    val userviewmodel = UserListViewModel(i)
                    arrayList.add(userviewmodel)
                }
                allayListMutableLivedata.value = arrayList
            }


        })

        return allayListMutableLivedata;
    }
}