package com.example.myapplication

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_resource.*

class Resource : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resource)

        val text1 = resources.getString(R.string.hello)
        Log.d("TEXT1", text1)

        val text2 = getString(R.string.hello)
        Log.d("TEXT2", text2)

        val color = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

            resource_button.setBackgroundColor(getColor(R.color.textview_background))
        }
        else {

            resource_button.setBackgroundColor(getColor(R.color.colorPrimary))
        }
    }
}
