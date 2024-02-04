package com.example.homework.hw18.calendar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.homework.R

class MainCalendarActivity : AppCompatActivity() {
    private lateinit var etDate: EditText
    private lateinit var etTime: EditText
    private lateinit var etDescription: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_calendar)
        initViews()
        btnSave.setOnClickListener {
            val date = etDate.text.toString()
            val time = etTime.text.toString()
            val description = etDescription.text.toString()
            val event = Event(date,time, description)
            navigateToSecondActivity(event)
        }
    }
    private fun initViews(){
        etDate = findViewById(R.id.etDate)
        etTime = findViewById(R.id.etTime)
        etDescription = findViewById(R.id.etDescription)
        btnSave = findViewById(R.id.btnSave)
    }
    private fun navigateToSecondActivity(event: Event){
        val intent = Intent(this, CalendarConfirmActivity::class.java)
        val bundle = Bundle()
        bundle.putSerializable("event", event)
        intent.putExtras(bundle)
        startActivity(intent)
    }
}