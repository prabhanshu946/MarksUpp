package com.demo.marksupp.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Query
import com.demo.marksupp.database.QuestionRelation
import com.demo.marksupp.database.entity.Question

@Dao
abstract class QuestionDao : BaseDao<Question>() {

    @Query("Select * from tbl_question where question_id=:questionId")
    abstract fun getQuestionDetail(questionId: Long): Question?

    @Query("select * from tbl_question")
    abstract fun getAllQuestions(): LiveData<List<QuestionRelation>>
}