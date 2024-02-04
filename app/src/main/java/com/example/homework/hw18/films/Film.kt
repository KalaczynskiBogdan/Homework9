package com.example.homework.hw18.films

import java.io.Serializable

class Film(val title: String, val director: String, val duration: String): Serializable{
    override fun toString(): String {
        return title
    }
}
