package com.yaman.myapp.firebase.chat

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.yaman.myapp.utils.showToast

class LoginModel {

    private val TAG = "LoginRepo"

    fun signInWithPhoneAuthCredential(context: Context, credential: PhoneAuthCredential) {
        FirebaseAuth.getInstance().signInWithCredential(credential)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    Log.v(TAG, "signInWithCredential:success ${task.result?.user?.uid}")
                } else {
                    Log.v(TAG, "signInWithCredential:failure ${task.exception}")
                    if (task.exception is FirebaseAuthInvalidCredentialsException)
                        context.showToast("Invalid verification code!")
                }
            }
    }


}