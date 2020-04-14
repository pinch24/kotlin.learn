package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_listener.*

class Listener : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listener)

        // var textView: TextView = findViewById<TextView>(R.id.hello)
        hello.setOnClickListener {

            Log.d("CLICK", "Click!")

            hello.setText("Good bye.")
            image.setImageResource(R.drawable.n13_stroke)
        }
    }
}
