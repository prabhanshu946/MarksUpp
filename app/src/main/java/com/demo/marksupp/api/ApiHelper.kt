package com.demo.marksupp.api

import com.demo.marksupp.api.response.StackQuestionsResponse
import retrofit2.Response

interface ApiHelper {
    suspend fun getQuestions(): Response<StackQuestionsResponse>
}