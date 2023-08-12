package com.yaman.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.yaman.myapp.coroutines_tutorials.MainActivityCoroutines
import com.yaman.myapp.coroutines_tutorials.MainActivityCoroutinesTwo
import com.yaman.myapp.coroutines_tutorials.MainActivityThreads
import com.yaman.myapp.firebase.chat.LoginFirebaseActivity
import com.yaman.myapp.rx_java_tutorials.MainActivityRxJava

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


        // Firebase
        startActivity(Intent(this,LoginFirebaseActivity::class.java))

        finish()
    }

}