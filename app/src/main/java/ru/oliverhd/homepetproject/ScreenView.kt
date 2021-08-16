package ru.oliverhd.homepetproject

import moxy.MvpView
import moxy.viewstate.strategy.alias.SingleState

interface ScreenView : MvpView {

    @SingleState
    fun error(error: Throwable)

}