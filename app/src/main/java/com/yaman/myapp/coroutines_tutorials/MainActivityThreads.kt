package com.yaman.myapp.coroutines_tutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.yaman.myapp.R
import com.yaman.myapp.databinding.ActivityMainThreadsBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.yield
import kotlin.concurrent.thread

class MainActivityThreads : AppCompatActivity() {

    private val TAG: String = "MainActivityThreads"
    lateinit var binding: ActivityMainThreadsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main_threads)
    }

    fun updateCounter(view: View) {
        Log.e("TAG", "updateCounter: Run")
        binding.counterText.text = "${binding.counterText.text.toString().toInt() + 1}"
    }

    fun doAction(view: View) {
        // Run Inside Another Thread - long running
        /*longRunningTaskInThread()*/

        // Run Using Coroutines
        longRunningTaskInCoroutine()

        GlobalScope.launch(Dispatchers.Main) {
            Log.e("GlobalScope: ", "doAction: ${Thread.currentThread()}")
        }

        MainScope().launch(Dispatchers.Default) {
            Log.e("MainScope: ", "doAction: ${Thread.currentThread()}")
        }

        // Suspend Functions
        lifecycleScope.launch(Dispatchers.Main) {
            task1()
        }

        lifecycleScope.launch(Dispatchers.Main) {
            task2()
        }
    }

    private fun longRunningTaskInCoroutine() {
        CoroutineScope(Dispatchers.IO).launch {
            Log.e("CoroutineScope: ", "doAction: ${Thread.currentThread()}")
            Log.e("longRunningTaskInCoroutine: ", "doAction: Run - IO Thread")
            for (i in 0..1000000000L) {

            }
        }
    }

    private fun longRunningTaskInThread() {
        thread(start = true) {
            Log.e("longRunningTaskInThread: ", "doAction: Run Another Thread")
            for (i in 0..1000000000L) {

            }
        }
    }

    suspend fun task1() {
        Log.e(TAG, "starting task1: ")
//        yield()
        delay(1000)
        Log.e(TAG, "ending task1: ")
    }

    suspend fun task2() {
        Log.e(TAG, "starting task2: ")
//        yield()
        delay(2000)
        Log.e(TAG, "ending task2: ")
    }

}