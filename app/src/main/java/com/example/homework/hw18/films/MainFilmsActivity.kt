package com.example.homework.hw18.films

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.homework.R

class MainFilmsActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_films)
        val listView = findViewById<ListView>(R.id.listViewTwo)
        val listOfFilms = ArrayList<Film>()
        listOfFilms.add(Film("Dunkirk", "Christopher Nolan", "1 hour 46 minutes"))
        listOfFilms.add(Film("Interstellar", "Christopher Nolan", "2 hours 49 minutes "))
        listOfFilms.add(Film("The Dark Knight", "Christopher Nolan", "2 hours 32 minutes"))
        listOfFilms.add(Film("The Prestige", "Christopher Nolan", "2 hours 10 minutes"))

        val adapter = ArrayAdapter(this, R.layout.test, listOfFilms)
        listView.adapter = adapter

        listView.setOnItemClickListener { parent, _, position, _ ->
            val selectedItem = parent.getItemAtPosition(position) as Film
            val intent = Intent(this, FilmInfoActivity::class.java)
            intent.putExtra("film", selectedItem)
            startActivity(intent)
        }
    }
}