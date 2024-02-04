package com.example.homework.hw18.films

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.activity.OnBackPressedCallback
import com.example.homework.R

class FilmInfoActivity : AppCompatActivity() {
    private lateinit var tvReceivedNameOfTheFilm: TextView
    private lateinit var tvReceivedDirector: TextView
    private lateinit var tvReceivedDuration: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_film_info)
        initViews()
        setInfo()
        onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                finishAffinity()
            }
        })
    }

    private fun initViews() {
        tvReceivedNameOfTheFilm = findViewById(R.id.tvReceivedNameOfTheFilm)
        tvReceivedDirector = findViewById(R.id.tvReceivedDirector)
        tvReceivedDuration = findViewById(R.id.tvReceivedDuration)
    }

    private fun setInfo() {
        val film = intent?.getSerializableExtra("film", Film::class.java)
        if (film != null) {
            tvReceivedNameOfTheFilm.text = film.title
            tvReceivedDirector.text = film.director
            tvReceivedDuration.text = film.duration
        }
    }
}