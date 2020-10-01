package com.example.miningmania

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.miningmania.source.Miner
import com.example.miningmania.source.data.Socket
import com.example.miningmania.source.сomponents.*

private var hashText: TextView? = null
private var moneyText: TextView? = null

private var stack: Stack = Stack(1, 1)
private var miner: Miner = Miner(0.01f)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        hashText = findViewById(R.id.HashPerSecond)
        moneyText = findViewById(R.id.Money)

        var board: BoardComponent =
            BoardComponent("TestBoard", 100.0f, Socket.AM4, 1, 1)
        board.AddCPU(CPU("CPU 1", 100.0f, 1000.0f, 100.0f, Socket.AM4), 0)
        board.AddGPU(GPU("GPU 1", 100.0f, 2000.0f, 200.0f), 0)

        stack.addBoard(board, 0)
        stack.addPowerSupply(PowerSupply("Power 1", 100.0f, 1000.0f), 0)

        miner.addStack(stack)

        startMining()
    }

    private fun startMining(){
        Thread{
            while(true){
                Thread.sleep(500)

                runOnUiThread {

                    moneyText?.text = miner.mine().toString()
                }
            }
        }.start()
    }
}