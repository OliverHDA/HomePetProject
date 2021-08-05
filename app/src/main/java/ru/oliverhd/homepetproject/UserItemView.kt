package ru.oliverhd.homepetproject

interface UserItemView : ItemView {
    fun setLogin(text: String)
    fun getLogin(): String
}