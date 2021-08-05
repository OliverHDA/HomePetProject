package ru.oliverhd.homepetproject.userslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.oliverhd.homepetproject.UserItemView
import ru.oliverhd.homepetproject.databinding.UsersRecyclerItemBinding

class UsersListRVAdapter(private val presenter: UserListPresenter) :
    RecyclerView.Adapter<UsersListRVAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            UsersRecyclerItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        ).apply {
            itemView.setOnClickListener { presenter.itemClickListener?.invoke(this) }
        }

    override fun getItemCount() = presenter.getCount()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        presenter.bindView(holder.apply { pos = position })

    inner class ViewHolder(private val vb: UsersRecyclerItemBinding) : RecyclerView.ViewHolder(vb.root),
        UserItemView {
        override var pos = -1

        override fun setLogin(text: String) = with(vb) {
            tvLogin.text = text
        }

        override fun getLogin(): String {
           return with(vb) {
               tvLogin.text.toString()
            }
        }
    }
}