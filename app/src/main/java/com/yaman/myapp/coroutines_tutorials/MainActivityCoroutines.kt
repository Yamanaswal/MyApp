package com.yaman.myapp.coroutines_tutorials

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.yaman.myapp.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivityCoroutines : AppCompatActivity() {

    private val TAG: String = "MainActivityCoroutines:"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_coroutines)

        val job = CoroutineScope(Dispatchers.IO).launch {
            printFollowers()
            printFollowersAsync()
        }
        Log.e(TAG, "onCreate: " + job.isActive)

        CoroutineScope(Dispatchers.IO).launch {
            Log.e(TAG, "onCreate: Two")

            val fb = async { getFacebookFollowers() }
            val insta = async { getInstagramFollowers() }
            Log.e(TAG, "fb followers:: -> $fb")
            Log.e(TAG, "insta followers:: -> ${insta.await()}")
        }

    }

    private suspend fun printFollowers() {
        var followers = 0
        //Job Object -
        val job = CoroutineScope(Dispatchers.IO).launch {
            followers = getFacebookFollowers()
        }
        job.join() // wait for job to complete here before execute to next line
        Log.e(TAG, "printFollowers: $followers")
    }

    private suspend fun printFollowersAsync() {
        //Deferred Object
        val job = CoroutineScope(Dispatchers.IO).async {
            getFacebookFollowers()
        }
        val followers = job.await() // wait for job to complete here before execute to next line
        Log.e(TAG, "printFollowersAsync: $followers")
    }

    private suspend fun getFacebookFollowers(): Int {
        delay(2000)
        return 56
    }

    private suspend fun getInstagramFollowers(): Int {
        delay(4000)
        return 100
    }


}