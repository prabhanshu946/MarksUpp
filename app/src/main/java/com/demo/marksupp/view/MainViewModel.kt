package com.demo.marksupp.view

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.demo.marksupp.repository.MainRepository
import com.demo.marksupp.shared.NetworkHelper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel() {

    internal fun getAllQuestions() = mainRepository.getAllQuestions()

    internal suspend fun getQuestions() {
        if (networkHelper.isNetworkConnected()) {
            viewModelScope.launch {
                mainRepository.getQuestions().let {
                    if (it.isSuccessful) {
                        it.body()?.items?.forEach { questionResponse ->
                            mainRepository.prepareQuestionData(questionResponse)
                        }
                    }
                }
            }
        }
    }
}