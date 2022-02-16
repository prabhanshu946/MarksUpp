package com.demo.marksupp.api

import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override suspend fun getQuestions() = apiService.getQuestions()
}