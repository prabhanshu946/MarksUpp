package com.demo.marksupp.view

import androidx.recyclerview.widget.DiffUtil
import com.demo.marksupp.database.QuestionRelation

class MainDiffUtil: DiffUtil.ItemCallback<QuestionRelation>() {
    override fun areItemsTheSame(oldItem: QuestionRelation, newItem: QuestionRelation): Boolean {
        return oldItem.question.question_id == newItem.question.question_id
    }

    override fun areContentsTheSame(oldItem: QuestionRelation, newItem: QuestionRelation): Boolean {
        return oldItem.question == newItem.question && oldItem.owner == newItem.owner && oldItem.tags == newItem.tags
    }
}