package com.demo.marksupp.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.demo.marksupp.database.QuestionRelation
import com.demo.marksupp.databinding.MainListItemBinding
import com.demo.marksupp.shared.MainDiffUtil


class MainListAdapter :
    ListAdapter<QuestionRelation, MainListAdapter.PostViewHolder>(MainDiffUtil()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostViewHolder {
        val view = MainListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostViewHolder(view)
    }

    override fun onBindViewHolder(holder: PostViewHolder, position: Int) {
        with(holder) {
            binding.question = getItem(absoluteAdapterPosition)
        }

    }

    class PostViewHolder(val binding: MainListItemBinding) : RecyclerView.ViewHolder(binding.root)
}