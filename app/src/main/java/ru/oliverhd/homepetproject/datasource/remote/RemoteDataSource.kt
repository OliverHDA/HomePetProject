package ru.oliverhd.homepetproject.datasource.remote

import ru.oliverhd.homepetproject.datasource.repositories.RepositoriesDataSource
import ru.oliverhd.homepetproject.datasource.users.UsersDataSource

interface RemoteDataSource: UsersDataSource, RepositoriesDataSource
