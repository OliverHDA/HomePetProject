package ru.oliverhd.homepetproject.userslist

import ru.oliverhd.homepetproject.ItemView
import ru.oliverhd.homepetproject.UserItemView

interface ListPresenter<V : ItemView> {
    var itemClickListener: ((V) -> Unit)?
    fun bindView(view: V)
    fun getCount(): Int
}

interface UserListPresenter : ListPresenter<UserItemView>