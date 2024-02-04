package com.example.homework.hw18.notes

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.TextView
import com.example.homework.R

class MainNotesActivity : AppCompatActivity() {
    private lateinit var tvOk: TextView
    private lateinit var etNote: EditText
    private var note = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_notes)
        initViews()
        if (savedInstanceState != null){
            note = savedInstanceState.getString("note").toString()
        }
        etNote.setOnFocusChangeListener{_,hasFocus ->
            tvOk.visibility = if (hasFocus) View.VISIBLE else View.INVISIBLE
        }
        tvOk.setOnClickListener{
            etNote.clearFocus()
            tvOk.hideKeyboard()
            note = etNote.text.toString()
            tvOk.visibility = View.INVISIBLE
        }
    }
    private fun initViews(){
        tvOk = findViewById(R.id.tvOk)
        etNote = findViewById(R.id.etNote)
    }
    private fun View.hideKeyboard() {
        val inputMethodManager = context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString("note", note)
    }
}