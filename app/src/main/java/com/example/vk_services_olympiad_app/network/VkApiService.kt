package com.example.vk_services_olympiad_app.network

import com.example.vk_services_olympiad_app.model.VkServices
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET


private const val BASE_URL =
    "https://mobile-olympiad-trajectory.hb.bizmrg.com/"

//
private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()



//Интерфейс, задающий логику общения с веб-сервером
interface VkApiService {
    @GET("semi-final-data.json")
    suspend fun getData(): VkServices
}


//Singleton-объект для создания только одного экземпляра Retrofit API service
object VkApi {
    val retrofitService: VkApiService by lazy {
        retrofit.create(VkApiService::class.java)
    }
}