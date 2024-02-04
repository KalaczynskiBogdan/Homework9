package com.example.homework.hw18.bookCatalog

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.homework.R

class BookInfoActivity : AppCompatActivity() {
    private lateinit var tvReceivedNameOfTheBook: TextView
    private lateinit var tvReceivedAuthor: TextView
    private lateinit var tvReceivedCountOfPages: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book_info)
        initViews()
        setInfo()
    }

    private fun initViews() {
        tvReceivedNameOfTheBook = findViewById(R.id.tvReceivedNameOfTheBook)
        tvReceivedAuthor = findViewById(R.id.tvReceivedAuthor)
        tvReceivedCountOfPages = findViewById(R.id.tvReceivedCountOfPages)
    }

    private fun setInfo() {
        val book = intent?.getParcelableExtra("book", Book::class.java)
        if (book != null) {
            tvReceivedNameOfTheBook.text = book.title
            tvReceivedAuthor.text = book.author
            tvReceivedCountOfPages.text = book.countOfPages
        }
    }
}