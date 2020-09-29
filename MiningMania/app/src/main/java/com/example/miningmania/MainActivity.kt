package com.example.miningmania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

private var hashText: TextView? = null
private var moneyText: TextView? = null
var i: Int = 0

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hashText = findViewById(R.id.HashPerSecond)
        moneyText = findViewById(R.id.Money)

        moneyText?.text = "100"

        Thread{
            while(true){
                Thread.sleep(500)
                i++

                runOnUiThread {
                    moneyText?.text = i.toString()
                }
            }
        }.start()

        //startMining()
    }

    private fun startMining(){
        Thread{
            Thread.sleep(500)
            i++
            moneyText?.text = i.toString()
        }
    }
}