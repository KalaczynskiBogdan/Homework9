package com.example.homework.hw18.catalog

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.homework.R

class CatalogAdapter : RecyclerView.Adapter<CatalogAdapter.PhoneViewHolder>() {
    private var listOfPhones: ArrayList<Phones> = ArrayList()
    private lateinit var onPhoneClickListener: OnPhoneClickListener

    fun setOnPhoneClickListener(onPhoneClickListener: OnPhoneClickListener) {
        this.onPhoneClickListener = onPhoneClickListener
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setListOfPhones(listOfPhones: ArrayList<Phones>) {
        this.listOfPhones = listOfPhones
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhoneViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.phone_item, parent, false
        )
        return PhoneViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: PhoneViewHolder, position: Int) {
        val phone = listOfPhones[position]
        val text = "${phone.name} ${phone.model}"
        viewHolder.textViewPhones.text = text
        viewHolder.itemView.setOnClickListener {
            onPhoneClickListener.onPhoneClick(position, phone)
        }
    }

    override fun getItemCount(): Int {
        return listOfPhones.size
    }

    class PhoneViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewPhones: TextView = itemView.findViewById(R.id.tvPhone)
    }

    interface OnPhoneClickListener {
        fun onPhoneClick(position: Int, phone: Phones)
    }
}
