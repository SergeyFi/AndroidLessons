package source.сomponents

import source.data.Socket

class CPU(type: ComponentType, name: String, price:Float, powerScore: Float, tdp: Float, val socket:Socket) :
    PowerComponent(type, name, price, powerScore, tdp) {
}