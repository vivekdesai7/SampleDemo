package com.example.smapledemo.Adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.smapledemo.R
import com.example.smapledemo.databinding.UserBinding
import com.example.smapledemo.viewModel.UserListViewModel

class CustomAdapter(private val context: Context, private val userList: ArrayList<UserListViewModel>) : RecyclerView.Adapter<CustomAdapter.CustomView>() {

    //the class is hodling the list view
    class CustomView(val userBinding: UserBinding) : RecyclerView.ViewHolder(userBinding.root) {

        fun bindItems(userViewModel: UserListViewModel) {
            this.userBinding.userModel = userViewModel
        }
    }


    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): CustomView {
        val layoutInflater = LayoutInflater.from(context)
        val userBinding:UserBinding = DataBindingUtil.inflate(layoutInflater,R.layout.list_layout,p0,false)

        return CustomView(userBinding);

    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: CustomView, p1: Int) {
        val UserModel = userList[p1]
        holder.bindItems(UserModel)

    }

    //this method is returning the view for each item in the list




}