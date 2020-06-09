package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*

class ListViewActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_list_view)

        val personList = ArrayList<Person>()

        for (i in 0 until 40) {

            personList.add(
                Person(name = "" + i + "th Person", number = "+82 00-0000-0000 $i")
            )
        }

        val adapter = ListViewAdapter(personList, LayoutInflater.from(this@ListViewActivity))
        listView.adapter = adapter
        listView.setOnItemClickListener { parent, view, position, id ->

            var personName = (adapter.getItem(position) as Person).name
            var phoneNumber = (adapter.getItem(position) as Person).number

            Toast.makeText(this@ListViewActivity, "$personName: $phoneNumber", Toast.LENGTH_SHORT).show()
        }
    }
}

class ListViewAdapter(
    private val personList: ArrayList<Person>,
    private val layoutInflater: LayoutInflater
): BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {

        //val view = layoutInflater.inflate(R.layout.activity_phone_book_item, null)
        //val personNameTextView = view.findViewById<TextView>(R.id.person_name)
        //personNameTextView.text = personList[position].name

        val view: View
        val holder: ViewHolder

        if (convertView == null) {

            view = layoutInflater.inflate(R.layout.activity_phone_book_item, null)
            holder = ViewHolder()
            holder.personName = view.findViewById(R.id.person_name)
            holder.phoneNumber = view.findViewById(R.id.phone_number)

            view.tag = holder
        }
        else {

            holder = convertView.tag as ViewHolder
            view = convertView
        }

        holder.personName?.text = personList[position].name
        holder.phoneNumber?.text = personList[position].number

        return view
    }

    override fun getItem(position: Int): Any {

        return personList[position]
    }

    override fun getItemId(position: Int): Long {

        return position.toLong()
    }

    override fun getCount(): Int {

        return personList.size
    }
}

class ViewHolder {

    var personName: TextView? = null
    var phoneNumber: TextView? = null
}