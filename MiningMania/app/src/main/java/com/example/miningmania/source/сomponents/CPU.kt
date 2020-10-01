package com.example.miningmania.source.сomponents

import com.example.miningmania.source.data.Socket

class CPU(name: String, price:Float, miningScore: Float, tdp: Float, val socket:Socket) :
    PowerComponent(ComponentType.CPU, name, price, miningScore, tdp) {
}