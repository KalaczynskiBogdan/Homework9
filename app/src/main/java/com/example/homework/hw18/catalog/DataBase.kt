package com.example.homework.hw18.catalog

class DataBase {
    private val listOfPhones: ArrayList<Phones> = ArrayList()

    fun makeList() {
        listOfPhones.add(Phones(1, "Iphone","XS", 2018))
        listOfPhones.add(Phones(2, "Iphone","XR", 2018))
        listOfPhones.add(Phones(3, "Iphone","X", 2017))
        listOfPhones.add(Phones(4, "Iphone","11 pro", 2019))
    }

    fun getList(): ArrayList<Phones>{
        return ArrayList(listOfPhones)
    }
}