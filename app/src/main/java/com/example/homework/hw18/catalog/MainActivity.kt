package com.example.homework.hw18.catalog

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.R

class MainActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private var catalogAdapter: CatalogAdapter? = null
    private val dataBase: DataBase = DataBase()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        dataBase.makeList()
        recyclerView = findViewById(R.id.rvFirst)
        catalogAdapter = CatalogAdapter()
        catalogAdapter?.setOnPhoneClickListener(object : CatalogAdapter.OnPhoneClickListener {
            override fun onPhoneClick(position: Int, phone: Phones) {
                val intent = InfoActivity.newIntent(
                    this@MainActivity, phone.name, phone.model, phone.year.toString()
                )
                startActivity(intent)
            }
        })
        recyclerView.adapter = catalogAdapter
    }

    override fun onResume() {
        super.onResume()
        showPhones()
    }

    private fun showPhones() {
        catalogAdapter?.setListOfPhones(dataBase.getList())
    }

    companion object {
        fun newIntent(context: Context): Intent {
            return Intent(context, MainActivity::class.java)
        }
    }
}