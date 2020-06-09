package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView

class PhoneBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_phone_book)

        val phoneBook = createFakePhoneBook(fakeNumber = 30)
        createPhoneBookList(phoneBook)
    }

    private fun createFakePhoneBook(fakeNumber: Int = 10, phoneBook: PhoneBook = PhoneBook()): PhoneBook {

        for (i in 0 until fakeNumber) {

            phoneBook.addPerson(
                Person(name = "" + i + "th Person", number = "+82 00-0000-0000 $i")
            )
        }

        return phoneBook
    }

    private fun createPhoneBookList(phoneBook: PhoneBook) {

        val layoutInflater = LayoutInflater.from(this@PhoneBookActivity)
        val container = findViewById<LinearLayout>(R.id.phonebook_list_container)

        for (i in 0 until phoneBook.personList.size) {

            val view = layoutInflater.inflate(R.layout.activity_phone_book_item, null)
            val personNameView = view.findViewById<TextView>(R.id.person_name)
            val phoneNumberView = view.findViewById<TextView>(R.id.phone_number)
            personNameView.text = phoneBook.personList[i].name
            phoneNumberView.text = phoneBook.personList[i].number
            addSetOnClickListener(phoneBook.personList[i], view)
            container.addView(view)
        }
    }

    fun addSetOnClickListener(person: Person, view: View) {

        view.setOnClickListener {

            val intent = Intent(this@PhoneBookActivity, PhoneBookDetailActivity::class.java)
            intent.putExtra("name", person.name)
            intent.putExtra("number", person.number)
            startActivity(intent)
        }
    }
}

class PhoneBook() {

    var personList = ArrayList<Person>()

    fun addPerson(person: Person) {

        personList.add(person)
    }
}

class Person(val name: String, var number: String) {

}