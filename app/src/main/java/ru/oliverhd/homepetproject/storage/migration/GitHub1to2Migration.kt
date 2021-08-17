package ru.oliverhd.homepetproject.storage.migration

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

object GitHub1to2Migration : Migration(1, 2) {

    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL(
            "CREATE TABLE repositories (id INTEGER NOT NULL PRIMARY KEY, name TEXT NOT NULL, owner TEXT NOT NULL, forks INTEGER NOT NULL, description TEXT, stargazers INTEGER NOT NULL);"
        )
    }
}