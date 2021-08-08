package ru.oliverhd.homepetproject.userslist

import moxy.MvpView
import moxy.viewstate.strategy.AddToEndSingleStrategy
import moxy.viewstate.strategy.StateStrategyType

@StateStrategyType(AddToEndSingleStrategy::class)
interface UsersListView : MvpView {
    fun init()
    fun updateList()
}