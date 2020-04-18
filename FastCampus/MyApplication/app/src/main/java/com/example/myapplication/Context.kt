package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

class Context : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_context)

        val context : Context = this
        val applicationContext = applicationContext

        Log.d("CONTEXT", context.toString())
        Log.d("APPLICATION_CONTEXT",  applicationContext.toString())
    }
}
