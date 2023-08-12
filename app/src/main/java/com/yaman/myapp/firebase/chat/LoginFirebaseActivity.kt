package com.yaman.myapp.firebase.chat

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.yaman.myapp.R
import com.yaman.myapp.databinding.ActivityLoginFirebaseBinding
import com.yaman.myapp.firebase.chat.fragments.auth.LoginFragment
import com.yaman.myapp.firebase.chat.fragments.auth.SignUpFragment
import com.yaman.myapp.utils.setFragment
import com.yaman.myapp.utils.setFragmentWithBackStack

class LoginFirebaseActivity : AppCompatActivity() {

    val binding: ActivityLoginFirebaseBinding by lazy {
        DataBindingUtil.setContentView(this, R.layout.activity_login_firebase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //load login fragment
        setFragmentWithBackStack(binding.container.id, LoginFragment(), "LoginFragment")


        binding.signUpId.setOnClickListener {
            setFragmentWithBackStack(binding.container.id, SignUpFragment(), "SignUpFragment")
        }
    }
}