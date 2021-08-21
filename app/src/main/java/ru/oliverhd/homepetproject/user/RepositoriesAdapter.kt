package ru.oliverhd.homepetproject.user

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import ru.oliverhd.homepetproject.R
import ru.oliverhd.homepetproject.databinding.RepositoriesRecyclerItemBinding
import ru.oliverhd.homepetproject.repository.GitHubRepository

class RepositoriesAdapter(private val delegate: Delegate?) :
    ListAdapter<GitHubRepository, RepositoriesAdapter.RepositoryViewHolder>(UserDiff) {

    interface Delegate {
        fun onRepositoryClicked(repository: GitHubRepository)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RepositoryViewHolder =
        RepositoryViewHolder(
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.repositories_recycler_item, parent, false)
        )

    override fun onBindViewHolder(holder: RepositoryViewHolder, position: Int) =
        holder.bind(getItem(position), delegate)

    class RepositoryViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val viewBinding: RepositoriesRecyclerItemBinding by viewBinding()

        fun bind(repository: GitHubRepository, delegate: Delegate?) {
            with(viewBinding) {
                repositoryNameRecyclerTextView.text = repository.name
                repositoryNameRecyclerTextView.setOnClickListener {
                    delegate?.onRepositoryClicked(repository)
                }
            }
        }

    }
}