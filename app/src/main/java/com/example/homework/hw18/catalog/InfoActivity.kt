package com.example.homework.hw18.catalog

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.homework.R

class InfoActivity : AppCompatActivity() {
    private lateinit var tvPhoneName: TextView
    private lateinit var tvPhoneModel: TextView
    private lateinit var tvPhoneYear: TextView
    private lateinit var buttonBack: Button

    companion object {
        private const val EXTRA_PHONE_NAME = "name"
        private const val EXTRA_PHONE_MODEL = "drink"
        private const val EXTRA_PHONE_YEAR = "additives"

        fun newIntent(context: Context, name: String, model: String, year: String): Intent {
            val intent = Intent(context, InfoActivity::class.java)
            intent.putExtra(EXTRA_PHONE_NAME, name)
            intent.putExtra(EXTRA_PHONE_MODEL, model)
            intent.putExtra(EXTRA_PHONE_YEAR, year)
            return intent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        initViews()
        selectInfo()
        buttonBack.setOnClickListener {
            val intent = MainActivity.newIntent(this)
            startActivity(intent)
        }
    }
    private fun initViews(){
        tvPhoneName = findViewById(R.id.tvName)
        tvPhoneModel = findViewById(R.id.tvModel)
        tvPhoneYear = findViewById(R.id.tvYear)
        buttonBack = findViewById(R.id.btnBack)
    }
    private fun selectInfo(){
        val name = intent.getStringExtra(EXTRA_PHONE_NAME).toString()
        val model = intent.getStringExtra(EXTRA_PHONE_MODEL).toString()
        val year = intent.getStringExtra(EXTRA_PHONE_YEAR).toString()

        tvPhoneName.text = name
        tvPhoneModel.text = model
        tvPhoneYear.text = year
    }
}