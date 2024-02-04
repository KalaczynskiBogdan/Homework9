package com.example.homework.hw18.bookCatalog

import android.os.Parcel
import android.os.Parcelable

data class Book(val title: String, val author: String, val countOfPages: String): Parcelable{
    constructor(parcel: Parcel) : this(
       title = parcel.readString() ?: "",
        author = parcel.readString() ?: "",
        countOfPages = parcel.readString() ?: ""
    )
    override fun describeContents(): Int {
       return 0
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(title)
        dest.writeString(author)
        dest.writeString(countOfPages)
    }
    companion object CREATOR : Parcelable.Creator<Book> {
        override fun createFromParcel(parcel: Parcel): Book {
            return Book(parcel)
        }

        override fun newArray(size: Int): Array<Book?> {
            return arrayOfNulls(size)
        }
    }

    override fun toString(): String {
        return title
    }
}