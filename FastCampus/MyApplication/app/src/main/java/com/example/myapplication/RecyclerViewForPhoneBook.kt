package com.example.myapplication

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_recycler_view_for_phone_book.*

class RecyclerViewForPhoneBook : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recycler_view_for_phone_book)

//        val phoneBook = createFakePhoneBook(30)
//        val phoneBookRecyclerAdapter = PhoneBookRecyclerAdapter(phoneBook, LayoutInflater.from(this@RecyclerViewForPhoneBook), this)
//
//        phonebook_recycler_view.adapter = phoneBookRecyclerAdapter
//        phonebook_recycler_view.layoutManager = LinearLayoutManager(this@RecyclerViewForPhoneBook)

        with(phonebook_recycler_view) {

            this.adapter = RecyclerViewrForPhoneBookAdapter(
                createFakePhoneBook(30),
                LayoutInflater.from(this@RecyclerViewForPhoneBook),
                this@RecyclerViewForPhoneBook
            )
            this.layoutManager = LinearLayoutManager(this@RecyclerViewForPhoneBook)
        }
    }

    private fun createFakePhoneBook(fakeNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()): PhoneBook {

        for (i in 0 until fakeNumber) {

            phoneBook.addPerson(
                Person(name = "" + i + "th Person", number = "+82 00-0000-0000 $i")
            )
        }

        return phoneBook
    }
}

class RecyclerViewrForPhoneBookAdapter(
    private val phoneBook: PhoneBook,
    private val inflater: LayoutInflater,
    val activity: Activity
): RecyclerView.Adapter<RecyclerViewrForPhoneBookAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {

        var personName: TextView

        init {

            personName = itemView.findViewById(R.id.person_name)

            itemView.setOnClickListener {

                val intent = Intent(activity, PhoneBookDetailActivity::class.java)
                intent.putExtra("name", phoneBook.personList[adapterPosition].name)
                intent.putExtra("number", phoneBook.personList[adapterPosition].number)
                activity.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = inflater.inflate(R.layout.activity_phone_book_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {

        return phoneBook.personList.size
    }

    override fun onBindViewHolder(holder: RecyclerViewrForPhoneBookAdapter.ViewHolder, position: Int) {

        holder.personName.text = phoneBook.personList[position].name
    }
}