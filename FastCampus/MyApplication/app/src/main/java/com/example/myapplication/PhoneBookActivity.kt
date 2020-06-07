package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater

class PhoneBookActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_phone_book)
    }

    fun createFakePhoneBook(fakeNumber: Int = 100, phoneBook: PhoneBook = PhoneBook()) {

        for (i in 0 until fakeNumber) {

            phoneBook.addPerson(
                Person(name = "" + i + "nd Person", number = "" + i + "nd Person's Phone Number")
            )
        }
    }

    fun createPhoneBookList(phoneBook: PhoneBook) {

        val layoutInflater = LayoutInflater.from(this@PhoneBookActivity)

        for (i in 0 until phoneBook.personList.size) {

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