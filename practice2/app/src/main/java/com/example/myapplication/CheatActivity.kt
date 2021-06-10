package com.example.myapplication

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class CheatActivity : AppCompatActivity() {

    private val answerTextView: TextView by lazy {
        findViewById(R.id.answerTextView)
    }
    private val showAnswerButton: Button by lazy {
        findViewById(R.id.answerButton)
    }

    private var answerIsTrue = false
    private var isCheater = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cheat)

        isCheater = savedInstanceState?.getBoolean("cheat", false) ?: false
        answerIsTrue = savedInstanceState?.getBoolean("answer", false) ?: false
                || intent.getBooleanExtra("answer", false)

        if (isCheater) {
            setTextView()
        }
        showAnswerButton.setOnClickListener {
            setTextView()
        }
    }

    private fun setTextView() {
        val answerText = when {
            answerIsTrue -> "True"
            else -> "False"
        }
        isCheater = true
        answerTextView.text = answerText
        setAnswerShownResult(true)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putBoolean("cheat", isCheater)
        outState.putBoolean("answer", answerIsTrue)
    }

    private fun setAnswerShownResult(isAnswerShown: Boolean) {
        val data = Intent().apply {
            putExtra("isCheater", isAnswerShown)
        }
        setResult(Activity.RESULT_OK, data)
    }

    companion object {
        fun newIntent(packageContext: Context, answerIsTrue: Boolean): Intent {
            return Intent(packageContext, CheatActivity::class.java).apply {
                putExtra("answer", answerIsTrue)
            }
        }
    }
}