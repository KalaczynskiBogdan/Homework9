package com.example.homework.hw18.profile

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.homework.R

class PersonInfoActivity : AppCompatActivity() {
    private lateinit var tvName: TextView
    private lateinit var tvSurname: TextView
    private lateinit var tvEmail: TextView

    companion object {
        private const val EXTRA_NAME = "name"
        private const val EXTRA_SURNAME = "surname"
        private const val EXTRA_EMAIL = "email"
        fun newIntent(
            context: Context,
            receivedName: String,
            receivedSurname: String,
            receivedEmail: String
        ): Intent {
            val intent = Intent(context, PersonInfoActivity::class.java)
            intent.putExtra(EXTRA_NAME, receivedName)
            intent.putExtra(EXTRA_SURNAME, receivedSurname)
            intent.putExtra(EXTRA_EMAIL, receivedEmail)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_person_info)
        initViews()
        setInfo()
    }

    private fun initViews() {
        tvName = findViewById(R.id.tvPersonName)
        tvSurname = findViewById(R.id.tvPersonSurname)
        tvEmail = findViewById(R.id.tvPersonEmail)
    }

    private fun setInfo() {
        val name = intent.getStringExtra(EXTRA_NAME).toString()
        val surname = intent.getStringExtra(EXTRA_SURNAME).toString()
        val email = intent.getStringExtra(EXTRA_EMAIL).toString()

        tvName.text = name
        tvSurname.text = surname
        tvEmail.text = email
    }
}