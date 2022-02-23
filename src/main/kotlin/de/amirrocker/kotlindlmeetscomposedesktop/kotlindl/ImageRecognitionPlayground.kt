package de.amirrocker.fantasticadventure.kotlindl

import org.jetbrains.kotlinx.dl.api.inference.loaders.ONNXModelHub
import org.jetbrains.kotlinx.dl.api.inference.onnx.ONNXModels
import org.jetbrains.kotlinx.dl.api.inference.onnx.OnnxInferenceModel
import org.jetbrains.kotlinx.dl.dataset.dogsCatsDatasetPath
import java.io.File

const val CACHE_PATH = "cache/pretrainedModels"
val dogsVsCatsDatasetPath = dogsCatsDatasetPath()

class ImageRecognitionPlayground {

    init {

        val model = loadModel(ONNXModels.CV.ResNet50noTopCustom)

        model.use {
            it.reshape(64, 64, 3)

        }


    }

    fun loadModelHub() = ONNXModelHub(cacheDirectory = File(CACHE_PATH))

    fun loadModel(model:ONNXModels.CV<OnnxInferenceModel>) = loadModelHub().loadModel(model)

}


