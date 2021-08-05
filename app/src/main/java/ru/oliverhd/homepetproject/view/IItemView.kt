package ru.oliverhd.homepetproject.view

interface IItemView {
    var pos: Int
}

interface UserItemView : IItemView {
    fun setLogin(text: String)
}