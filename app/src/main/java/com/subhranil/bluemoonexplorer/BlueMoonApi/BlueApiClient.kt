package com.subhranil.bluemoonexplorer.BlueMoonApi

import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.features.json.*
import io.ktor.client.features.json.serializer.*
import kotlinx.serialization.json.Json
import kotlinx.serialization.serializer

class BlueApiClient {
    companion object{
        fun getClient(): HttpClient{
            return HttpClient(Android){
                install(JsonFeature) {
                    serializer = KotlinxSerializer()
//                    ignoreUnknownKeys = true
                }
            }
        }
    }
}