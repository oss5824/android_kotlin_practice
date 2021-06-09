package com.example.myapplication

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var text: TextView
    private lateinit var view: View
    private lateinit var toastGravity:Toast
    private lateinit var toastScale:Toast
    private val toastGravityButton: Button by lazy{
        findViewById(R.id.toastGravityButton)
    }
    private val toastScaleButton: Button by lazy{
        findViewById(R.id.toastScaleButton)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toastGravityButton.setOnClickListener {
            toastGravity = Toast.makeText(
                this, getString(R.string.toast_gravity),
                Toast.LENGTH_SHORT
            )
            toastGravity.setGravity(Gravity.TOP, 200, 200)
            toastGravity.show()
        }

        toastScaleButton.setOnClickListener {
            view = layoutInflater.inflate(R.layout.toast_boarder,findViewById(R.id.toast_layout_root))
            text = view.findViewById(R.id.textView)
            text.text="토스트 크기"

            toastScale = Toast(applicationContext)
            toastScale.duration=Toast.LENGTH_SHORT
            toastScale.setGravity(Gravity.LEFT,300,300)
            toastScale.view=view
            toastScale.show()
        }

    }
}