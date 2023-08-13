package com.yaman.myapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.yaman.myapp.firebase.chat.LoginFirebaseActivity
import com.yaman.myapp.utils.Helper

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Compose UI
        // startActivity(Intent(this, MainActivityCompose::class.java))

        // Coroutines and threads - Coroutines Scope and Coroutines Context
        // startActivity(Intent(this, MainActivityThreads::class.java))

        // Coroutines - Job
        // startActivity(Intent(this, MainActivityCoroutines::class.java))

        // Coroutines Two - RunBlocking & WithContext - Job
        // startActivity(Intent(this, MainActivityCoroutinesTwo::class.java))

        // RxJava & Android
        // startActivity(Intent(this, MainActivityRxJava::class.java))

//        Helper.printHashKey(this)

        // Firebase
        startActivity(Intent(this, LoginFirebaseActivity::class.java))

        finish()
    }

}