package com.example.anindaemlak.service

import com.example.anindaemlak.model.Emlak
import io.reactivex.Single
import retrofit2.http.GET

interface EmlakAPI {
    companion object {
        private const val taskChartResult = "/propertylisting/"
    }
    @GET(taskChartResult)
    fun getDataEmlak(): Single<Emlak>
}