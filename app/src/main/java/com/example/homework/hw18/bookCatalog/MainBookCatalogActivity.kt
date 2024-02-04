package com.example.homework.hw18.bookCatalog

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.homework.R

class MainBookCatalogActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_book_catalog)
        val listView = findViewById<ListView>(R.id.listView)
        val listOfBooks = ArrayList<Book>()
        listOfBooks.add(Book("Harry Potter and the Philosopher's Stone", "J.K.Rowling", "320"))
        listOfBooks.add(Book("Harry Potter and the Chamber of Secrets", "J.K.Rowling", "352"))
        listOfBooks.add(Book("Harry Potter and the Prisoner of Azkaban", "J.K.Rowling", "448"))
        listOfBooks.add(Book("Harry Potter and the Goblet of Fire", "J.K.Rowling", "640"))

        val adapter = ArrayAdapter(this, R.layout.test, listOfBooks)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, _, position, _ ->
            val selectedItem = parent.getItemAtPosition(position) as Book
            val intent = Intent(this, BookInfoActivity::class.java)
            intent.putExtra("book", selectedItem)
            startActivity(intent)
        }
    }
}