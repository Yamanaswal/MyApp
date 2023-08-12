package com.yaman.myapp.utils

import android.content.Context
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment


fun Context.showToast(text: String) {
    Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
}


fun AppCompatActivity.setFragment(resId: Int, fragment: Fragment) {
    supportFragmentManager
        .beginTransaction()
        .replace(resId, fragment)
        .commit()
}

fun AppCompatActivity.setFragmentWithBackStack(resId: Int, fragment: Fragment, name: String) {
    supportFragmentManager
        .beginTransaction()
        .replace(resId, fragment)
        .addToBackStack(name)
        .commit()
}