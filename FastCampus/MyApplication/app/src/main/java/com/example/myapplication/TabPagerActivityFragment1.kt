package com.example.myapplication

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class TabPagerActivityFragment1 : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        Log.d("LIFE_CYCLE", "F1 onCreateView")

        return inflater.inflate(R.layout.activity_tab_pager_fragment1,  container, false)
    }
}
