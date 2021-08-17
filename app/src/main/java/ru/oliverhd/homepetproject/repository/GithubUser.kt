package ru.oliverhd.homepetproject.repository

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Dao
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "github_users")
@Parcelize
data class GithubUser(
    @PrimaryKey
    @SerializedName("id")
    val id: String,
    @ColumnInfo(name = "login")
    @SerializedName("login")
    val login: String,
    @ColumnInfo(name = "avatar")
    @SerializedName("avatar_url")
    val avatarUrl: String?,
    @ColumnInfo(name = "repos")
    @SerializedName("repos_url")
    val reposUrl: String
) : Parcelable