package com.example.homework.hw18.calendar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.homework.R

class CalendarConfirmActivity : AppCompatActivity() {
    private lateinit var tvDateReceived: TextView
    private lateinit var tvTimeReceived: TextView
    private lateinit var tvDescriptionReceived: TextView
    private lateinit var btnConfirm: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calendar_confirm)
        initViews()
        setEvent()
        btnConfirm.setOnClickListener {
            finishAffinity()
        }
    }

    private fun initViews() {
        tvDateReceived = findViewById(R.id.tvDateReceived)
        tvTimeReceived = findViewById(R.id.tvTimeReceived)
        tvDescriptionReceived = findViewById(R.id.tvDescriptionReceived)
        btnConfirm = findViewById(R.id.btnConfirm)
    }

    private fun setEvent() {
        val bundle = intent.extras
        val event = bundle?.getSerializable("event", Event::class.java)
        if (event != null) {
            tvDateReceived.text = event.date
            tvTimeReceived.text = event.time
            tvDescriptionReceived.text = event.description
        }
    }
}