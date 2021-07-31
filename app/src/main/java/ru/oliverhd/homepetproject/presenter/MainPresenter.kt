package ru.oliverhd.homepetproject.presenter

import ru.oliverhd.homepetproject.model.CountersModel
import ru.oliverhd.homepetproject.view.MainView

class MainPresenter(private val view: MainView, private val model: CountersModel) {

    fun counterOneClick() {
        view.showCounterOne(model.next(0).toString())
    }

    fun counterTwoClick() {
        view.showCounterTwo(model.next(1).toString())
    }

    fun counterThreeClick() {
        view.showCounterThree(model.next(2).toString())
    }
}