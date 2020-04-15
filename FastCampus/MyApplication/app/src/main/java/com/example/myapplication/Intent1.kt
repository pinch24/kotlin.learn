package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_intent1.*

class Intent1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_intent1)

        change_activity.setOnClickListener {

            var intent = Intent(this@Intent1, Intent2::class.java)
            intent.apply {

                this.putExtra("number1", 1)
                this.putExtra("number2", 2)
            }
            startActivityForResult(intent, 200)
//            var intent = Intent(Intent.ACTION_VIEW, Uri.parse("http://m.naver.com"))
//            startActivity(intent)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if (requestCode == 200) {

            Log.d("request_code", "" + requestCode)
            Log.d("result_code", "" + resultCode)

            var result = data?.getIntExtra("result", 0)
            Log.d("result", "" + result)
        }

        super.onActivityResult(requestCode, resultCode, data)
    }

}
