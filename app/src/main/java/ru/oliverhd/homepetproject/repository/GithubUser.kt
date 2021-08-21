package ru.oliverhd.homepetproject.repository

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class GithubUser(
    @SerializedName("login") val login: String,
    @SerializedName("id") val id: String,
    @SerializedName("avatar_url") val avatarUrl: String?,
    @SerializedName("repos_url") val reposUrl: String
) : Parcelable