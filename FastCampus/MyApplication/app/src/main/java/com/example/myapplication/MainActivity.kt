package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.n11_final)

        Log.d("LIFE CYCLE", "onCreate")
    }

    override fun onStart() {

        super.onStart()

        Log.d("LIFE CYCLE", "onStart")
    }

    override fun onResume() {

        super.onResume()

        Log.d("LIFE CYCLE", "onResume")
    }

    override fun onPause() {

        super.onPause()

        Log.d("LIFE CYCLE", "onPause")
    }

    override fun onStop() {

        super.onStop()

        Log.d("LIFE CYCLE", "onStop")
    }

    override fun onDestroy() {

        super.onDestroy()

        Log.d("LIFE CYCLE", "onDestroy")
    }
}