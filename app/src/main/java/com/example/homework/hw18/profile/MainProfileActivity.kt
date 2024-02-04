package com.example.homework.hw18.profile

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.example.homework.R

class MainProfileActivity : AppCompatActivity() {
    private lateinit var etName: EditText
    private lateinit var etSurname: EditText
    private lateinit var etEmail: EditText
    private lateinit var btnSave: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_profile)
        initViews()
        btnSave.setOnClickListener {
            saveInfo()
        }
    }

    private fun initViews() {
        etName = findViewById(R.id.etName)
        etSurname = findViewById(R.id.etSurname)
        etEmail = findViewById(R.id.etEmail)
        btnSave = findViewById(R.id.btnSave)
    }

    private fun saveInfo() {
        val name = etName.text.toString()
        val surname = etSurname.text.toString()
        val email = etEmail.text.toString()

        val intent = PersonInfoActivity.newIntent(this, name, surname, email)
        startActivity(intent)
    }
}