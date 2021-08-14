package ru.oliverhd.homepetproject.user

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

@SingleState
interface UserView : MvpView {
    fun showUserLogin(login: String)
    fun error (error: Throwable)
}