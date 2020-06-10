package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_tab_pager.*

class TabPagerAdapterActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_tab_pager_adapter)

        tab_layout.addTab(tab_layout.newTab().setText("ONE"))
        tab_layout.addTab(tab_layout.newTab().setText("TWO"))
        tab_layout.addTab(tab_layout.newTab().setText("THREE"))

        val pagerAdapter = TabPagerAdapter(LayoutInflater.from(this@TabPagerAdapterActivity))
        view_pager.adapter = pagerAdapter
        view_pager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tab_layout))

        tab_layout.addOnTabSelectedListener(object: TabLayout.OnTabSelectedListener {

            override fun onTabReselected(tab: TabLayout.Tab?) {

            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {

            }

            override fun onTabSelected(tab: TabLayout.Tab?) {

                view_pager.currentItem = tab!!.position
            }
        })
    }
}

class TabPagerAdapter(var layoutInflater: LayoutInflater): PagerAdapter() {

    override fun instantiateItem(container: ViewGroup, position: Int): Any {

        return when (position) {
            0 -> {
                val view = layoutInflater.inflate(R.layout.activity_tab_pager_fragment1, container, false)
                container.addView(view)
                view
            }
            1 -> {
                val view = layoutInflater.inflate(R.layout.activity_tab_pager_fragment2, container, false)
                container.addView(view)
                view
            }
            2 -> {
                val view = layoutInflater.inflate(R.layout.activity_tab_pager_fragment3, container, false)
                container.addView(view)
                view
            }
            else -> {
                val view = layoutInflater.inflate(R.layout.activity_tab_pager_fragment1, container, false)
                container.addView(view)
                view
            }
        }
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {

        container.removeView(`object` as View)
    }

    override fun getCount(): Int {

        return 3
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {

        return view === `object` as View
    }
}