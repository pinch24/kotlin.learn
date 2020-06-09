package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_phone_book_item.view.*
import kotlinx.android.synthetic.main.activity_recycler_view.*

class RecyclerViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recycler_view)

        val phoneBookList = ArrayList<Person>()

        for (i in 0 until 64) {

            phoneBookList.add(
                Person(name = "" + i + "th Person", number = "+82 00-0000-0000 $i")
            )
        }

        val adapter = RecyclerViewAdapter(phoneBookList, LayoutInflater.from(this@RecyclerViewActivity))
        recycler_view.adapter = adapter
        recycler_view.layoutManager = GridLayoutManager(this@RecyclerViewActivity, 2)
    }
}

class RecyclerViewAdapter(
    private val itemList: ArrayList<Person>,
    private val inflater: LayoutInflater
): RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var personName: TextView? = null
        var phoneNumber: TextView? = null

        init {

            personName = itemView.findViewById(R.id.person_name)
            phoneNumber = itemView.findViewById(R.id.phone_number)
            itemView.setOnClickListener {
                val position: Int = adapterPosition
                val phoneNumber = itemList[position].number
                Log.d("NUMBER: ", phoneNumber)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = inflater.inflate(R.layout.activity_phone_book_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return itemList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.personName?.text  = itemList[position].name
        holder.phoneNumber?.text = itemList[position].number
    }


}
