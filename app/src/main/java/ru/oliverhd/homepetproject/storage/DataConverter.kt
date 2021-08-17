package ru.oliverhd.homepetproject.storage

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import ru.oliverhd.homepetproject.repository.GithubUser
import java.lang.reflect.Type


class DataConverter {
    @TypeConverter
    fun fromGithubUserToString(githubUser: GithubUser): String {
        val gson = Gson()
        val type: Type = object : TypeToken<GithubUser>() {}.type
        return gson.toJson(githubUser, type)
    }

    @TypeConverter
    fun toGithubUser(githubUserString: String): GithubUser {

        val gson = Gson()
        val type: Type = object : TypeToken<GithubUser>() {}.type
        return gson.fromJson(githubUserString, type)
    }
}