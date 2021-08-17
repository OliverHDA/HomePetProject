package ru.oliverhd.homepetproject.repository

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Entity(tableName = "repositories")
@Parcelize
data class GitHubRepository(
    @PrimaryKey
    @SerializedName("id")
    val id: Int,

    @ColumnInfo(name = "name")
    @SerializedName("name")
    val name: String,

    @ColumnInfo(name = "owner")
    @SerializedName("owner")
    val owner: GithubUser,

    @ColumnInfo(name = "description")
    @SerializedName("description")
    val description: String?,

    @ColumnInfo(name = "stargazers")
    @SerializedName("stargazers_count")
    val stargazersCount: Int = 0,

    @ColumnInfo(name = "forks")
    @SerializedName("forks_count")
    val forksCount: Int = 0
) : Parcelable