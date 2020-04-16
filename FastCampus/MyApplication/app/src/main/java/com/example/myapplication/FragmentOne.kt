package com.example.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_fragment_one.*

class FragmentOne : Fragment() {

    interface OnDataPassListener {

        fun onDataPass(data : String?)
    }

    lateinit var dataPassListener : OnDataPassListener

    override fun onAttach(context: Context?) {

        super.onAttach(context)

        Log.d("LIFE_CYCLE", "F onAttach")

        dataPassListener = context as OnDataPassListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        Log.d("LIFE_CYCLE", "F onCreate")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        Log.d("LIFE_CYCLE", "F onCreateView")

        return inflater.inflate(R.layout.activity_fragment_one,  container, false)
        // return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)

        Log.d("LIFE_CYCLE", "F onViewCreated")

        send_button.setOnClickListener {

            dataPassListener.onDataPass("Good bye.")
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {

        super.onActivityCreated(savedInstanceState)

        val data = arguments?.getString("HELLO")

        Log.d("LIFE_CYCLE", "F onActivityCreated: [$data]")
    }

    override fun onStart() {

        super.onStart()

        Log.d("LIFE_CYCLE", "F onStart")
    }

    override fun onResume() {

        super.onResume()

        Log.d("LIFE_CYCLE", "F onResume")
    }

    override fun onPause() {

        super.onPause()

        Log.d("LIFE_CYCLE", "F onPause")
    }

    override fun onStop() {

        super.onStop()

        Log.d("LIFE_CYCLE", "F onStop")
    }

    override fun onDestroyView() {

        super.onDestroyView()

        Log.d("LIFE_CYCLE", "F onDestroyView")
    }

    override fun onDetach() {

        super.onDetach()

        Log.d("LIFE_CYCLE", "F onDetach")
    }
}