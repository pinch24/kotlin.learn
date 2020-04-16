package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_fragment.*

class FragmentActivity : AppCompatActivity(), FragmentOne.OnDataPassListener {

    override fun onDataPass(data: String?) {

        //Log.d("SENDED", "----> [$data]")
        Log.d("LIFE_CYCLE", "----> [$data]" )
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        Log.d("LIFE_CYCLE", "A onCreate")

        val fragmentOne = FragmentOne()
        val bundle = Bundle()
        bundle.putString("HELLO", "Hello, world.")
        fragmentOne.arguments = bundle

        show_button.setOnClickListener {

            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.fragment_container, fragmentOne)
            fragmentTransaction.commit()
        }

        hide_button.setOnClickListener {

            val fragmentManager = supportFragmentManager
            val fragmentTransaction = fragmentManager.beginTransaction()
            // fragmentTransaction.detach(fragmentOne)
            fragmentTransaction.remove(fragmentOne)
            fragmentTransaction.commit()
        }
    }

    override fun onStart() {

        super.onStart()

        Log.d("LIFE_CYCLE", "A onStart")
    }

    override fun onResume() {

        super.onResume()

        Log.d("LIFE_CYCLE", "A onResume")
    }

    override fun onPause() {

        super.onPause()

        Log.d("LIFE_CYCLE", "A onPause")
    }

    override fun onStop() {

        super.onStop()

        Log.d("LIFE_CYCLE", "A onStop")
    }

    override fun onDestroy() {

        super.onDestroy()

        Log.d("LIFE_CYCLE", "A onDestroy")
    }
}
