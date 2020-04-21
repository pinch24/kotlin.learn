package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_thread.*

class ThreadActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_thread)

        val runnable: Runnable = object : Runnable {

            override fun run() {

                Log.d("THREAD", "Thread-1 is made.")

                thread_button.setBackgroundColor(getColor(R.color.colorPrimaryDark))
            }
        }

        val thread: Thread = Thread(runnable)

        thread_button.setOnClickListener {

            thread.start()
        }

        Thread(object : Runnable {

            override fun run() {

                Log.d("THREAD", "Thread-2 is made.")
            }
        }).start()

        Thread(Runnable {

            Log.d("THREAD", "Thread-3 is made.")

            Thread.sleep(2000)

            runOnUiThread {

                thread_button.setBackgroundColor(getColor(R.color.textview_background))
            }
        }).start()
    }
}
