package com.yaman.myapp.firebase.chat

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.yaman.myapp.R
import com.yaman.myapp.databinding.ActivityChatFirebaseBinding


class ChatFirebaseActivity : AppCompatActivity() {

    private val databaseReference: FirebaseDatabase by lazy {
        FirebaseDatabase.getInstance()
    }

    private val binding: ActivityChatFirebaseBinding by lazy {
        DataBindingUtil.setContentView(this,R.layout.activity_chat_firebase)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    fun readFromDatabase() {
        // Read from the database

    }
}