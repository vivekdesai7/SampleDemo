package com.example.smapledemo.View

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.smapledemo.BR
import com.example.smapledemo.BR.viewModel
import com.example.smapledemo.Interface.LoginResultCallBack
import com.example.smapledemo.R
import com.example.smapledemo.viewModel.LoginViewModel
import com.example.smapledemo.viewModel.LoginViewModelFactory
import com.example.smapledemo.databinding.ActivityMainBinding
import es.dmoral.toasty.Toasty

class MainActivity : AppCompatActivity(),LoginResultCallBack {
    override fun onSuccess(message: String) {
        val intent = Intent(this@MainActivity,UserActivity::class.java)
        startActivity(intent)
        Toasty.success(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onError(message: String) {
        Toasty.error(this,message, Toast.LENGTH_SHORT).show()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val activityMainBinding = DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

       activityMainBinding.viewModel = ViewModelProviders.of(this,LoginViewModelFactory(this))
           .get(LoginViewModel::class.java)


    }

}
