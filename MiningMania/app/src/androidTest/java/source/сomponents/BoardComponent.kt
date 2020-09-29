package source.сomponents

import source.data.Socket

class BoardComponent(type: ComponentType, name: String, price:Float,
                     val socket: Socket, private val cpuCount:Int, private val gpuCount:Int) :
    Component(type, name, price) {

    private var score:Float = 0.0f
    private val cpus = Array<CPU?>(cpuCount){null}
    private var gpus = Array<GPU?>(gpuCount){null}

    fun AddCPU(cpu: CPU, index: Int) : CPU? {

        if (cpus.size > index) {

            val buf = cpus[index]

            cpus[index] = cpu

            return buf
        }

        return null;
    }

    fun AddGPU(gpu: GPU, index: Int) : GPU? {

        if (gpus.size > index) {

            val buf = gpus[index]

            gpus[index] = gpu

            return buf
        }

        return null;
    }

    fun calculateTDP(): Float{
        var tdp = 0.0f

        for (cpu in cpus){
            if (cpu != null){
                tdp += cpu.tdp
            }
        }

        for (gpu in gpus){
            if (gpu != null){
                tdp += gpu.tdp
            }
        }

        return tdp
    }

    fun calculateMiningScore(): Float{
        var score = 0.0f

        for (cpu in cpus){
            if (cpu != null){
                score += cpu.miningScore
            }
        }

        for (gpu in gpus){
            if (gpu != null){
                score += gpu.miningScore
            }
        }
        return score
    }
}