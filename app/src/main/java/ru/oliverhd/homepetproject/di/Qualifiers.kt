package ru.oliverhd.homepetproject.di

import javax.inject.Qualifier

@Qualifier
annotation class InMemory

@Qualifier
annotation class Persisted

@Qualifier
annotation class UsersListScreenFragment