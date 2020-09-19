package com.example.huification

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private val xue:String = "Хуе"
    private val stops = setOf('о', 'и', 'у', 'е')

    private var xuiresult:TextView? = null
    private var xuificateBtn:Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        xuiresult = findViewById(R.id.xuiresult)
        xuificateBtn = findViewById(R.id.xuificate)
    }

    fun xuificate(text:String): String {

        if (text.isEmpty()){
            return "";
        }

        var index = 0
        for (char in text) {
            if (stops.contains(char)){
                break;
            }
            index++
        }

        if (index + 1 >= text.length)
        {
            return xue + text;
        }

        return xue + text.substring(index + 1, text.length)
    }

    fun onClickHuificate(view: View){
        xuiresult?.setText(xuificate(xuiresult?.text.toString()))
    }
}