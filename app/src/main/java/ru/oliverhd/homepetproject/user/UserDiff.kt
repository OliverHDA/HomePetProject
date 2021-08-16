package ru.oliverhd.homepetproject.user

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.oliverhd.homepetproject.repository.GitHubRepository

object UserDiff : DiffUtil.ItemCallback<GitHubRepository>() {

    private val payload = Any()

    override fun areItemsTheSame(oldItem: GitHubRepository, newItem: GitHubRepository): Boolean {
        return oldItem.id == newItem.id
    }

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: GitHubRepository, newItem: GitHubRepository): Boolean {
        return oldItem == newItem
    }

    override fun getChangePayload(oldItem: GitHubRepository, newItem: GitHubRepository) = payload
}

