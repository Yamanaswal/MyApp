package com.yaman.myapp.coroutines_tutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.lifecycleScope
import com.yaman.myapp.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

class MainActivityCoroutinesTwo : AppCompatActivity() {

    private val TAG = "MainActivityCoroutinesTwo"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_coroutines_two)

        lifecycleScope.launchWhenCreated {
            executeTask()

            //Blocking Task
            withContext(Dispatchers.Main){
                executeTask()
            }
        }

        //Block a Coroutines until completed
        runBlocking {
            executeTask()
        }


    }

    private suspend fun executeTask() {
        Log.e(TAG, "executeTask: Before.")

        lifecycleScope.launch {
            delay(2000)
            Log.e(TAG, "executeTask: Inside.")
        }

        Log.e(TAG, "executeTask: After.")
    }



}