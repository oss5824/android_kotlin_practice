package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private lateinit var trueButton: Button
    private lateinit var falseButton: Button

    private lateinit var prevButton: ImageButton
    private lateinit var nextButton: ImageButton

    private lateinit var questionTextView: TextView

    private var currentIndex = 0

    private val questionBank = listOf(
        Question(R.string.australia, true),
        Question(R.string.oceans, true),
        Question(R.string.mideast, false),
        Question(R.string.africa, false),
        Question(R.string.americas, true),
        Question(R.string.asia, true)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        trueButton = findViewById(R.id.trueButton)
        falseButton = findViewById(R.id.falseButton)
        prevButton = findViewById(R.id.prevButton)
        nextButton = findViewById(R.id.nextButton)
        questionTextView = findViewById(R.id.questionTextView)

        trueButton.setOnClickListener {
            checkAnswer(true)
        }
        falseButton.setOnClickListener {
            checkAnswer(false)
        }
        prevButton.setOnClickListener {
            currentIndex = if (currentIndex == 0) questionBank.size - 1 else currentIndex - 1
            updateQuestion()
        }
        nextButton.setOnClickListener {
            currentIndex = (currentIndex + 1) % questionBank.size
            updateQuestion()
        }
        updateQuestion()
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val correctAnswer = questionBank[currentIndex].answer

        val messageResId=if(userAnswer==correctAnswer){
            "정답"
        }else{
            "오답"
        }
        Toast.makeText(this,messageResId,Toast.LENGTH_SHORT).show()
    }

    private fun updateQuestion() {
        val questionTextResId = questionBank[currentIndex].textResId
        questionTextView.setText(questionTextResId)
    }
}