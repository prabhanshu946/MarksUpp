package com.demo.marksupp.api

import com.demo.marksupp.api.response.StackQuestionsResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("2.2/questions?key=ZiXCZbWaOwnDgpVT9Hx8IA((&ord\n" +
            "er=desc&sort=activity&site=stackoverflow")
    suspend fun getQuestions(): Response<StackQuestionsResponse>
}