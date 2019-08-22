package com.example.smapledemo.View

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import com.example.smapledemo.Adapter.CustomAdapter
import com.example.smapledemo.Model.UserList
import com.example.smapledemo.R
import com.example.smapledemo.viewModel.UserListViewModel

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        var recyclerView:RecyclerView?=null
        var customlistAdapter:CustomAdapter?=null



            recyclerView = findViewById(R.id.recyclerView) as RecyclerView

            var userListViewModel: UserListViewModel = ViewModelProviders.of(this).get(UserListViewModel::class.java)

            userListViewModel.getMutableArraylist().observe(this, Observer{ userListViewModels->

                customlistAdapter= CustomAdapter(this,userListViewModels!!);
                recyclerView!!.layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL, false)

                recyclerView!!.adapter = customlistAdapter
            })

        }
    }
