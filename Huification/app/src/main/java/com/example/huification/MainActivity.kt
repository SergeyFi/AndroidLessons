package com.example.huification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    private val xue:String = "Хуе"
    private val stops:Array<String> = arrayOf("о", "и", "у")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun xuificate(text:String) {

        var textSplited = text.split(*stops)


    }
}