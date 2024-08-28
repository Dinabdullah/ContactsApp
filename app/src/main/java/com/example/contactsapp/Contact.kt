package com.example.contactsapp

import androidx.annotation.DrawableRes

data class Contact(
    @DrawableRes val pictureDrawable: Int = R.drawable.auntie,
    val name: String,
    val number: String,
)



