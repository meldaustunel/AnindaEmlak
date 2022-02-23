package com.example.anindaemlak.service

import com.example.anindaemlak.model.Emlak
import com.google.gson.GsonBuilder
import io.reactivex.Single
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class EmlakApiService {
    private val BASE_URL = "https://api.talebe.app"
    var gson = GsonBuilder()
        .setLenient()
        .create()

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(EmlakAPI::class.java)

    fun getEmlakData() : Single<Emlak> {
        return retrofit.getDataEmlak()
    }

}