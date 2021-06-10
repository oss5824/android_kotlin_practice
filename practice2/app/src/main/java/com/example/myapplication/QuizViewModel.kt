package com.example.myapplication

import androidx.lifecycle.ViewModel

class QuizViewModel : ViewModel() {

    private var currentIndex = 0
    private var isCheater = false

    private val questionBank = listOf(
        Question(R.string.australia, true),
        Question(R.string.oceans, true),
        Question(R.string.mideast, false),
        Question(R.string.africa, false),
        Question(R.string.americas, true),
        Question(R.string.asia, true)
    )

    val currentQuestionAnswer: Boolean
        get() = questionBank[currentIndex].answer

    val currentQuestionText: Int
        get() = questionBank[currentIndex].textResId

    fun getIndex(): Int {
        return currentIndex
    }
    fun getIsCheater(): Boolean{
        return isCheater
    }

    fun setIndex(index: Int) {
        currentIndex = index
    }
    fun setIsCheater(cheat: Boolean){
        isCheater=cheat
    }

    fun moveToNext() {
        currentIndex = (currentIndex + 1) % questionBank.size
    }

    fun moveToPrev() {
        currentIndex = if (currentIndex == 0) questionBank.size - 1 else currentIndex - 1
    }
}