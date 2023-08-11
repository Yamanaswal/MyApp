package com.yaman.myapp.rx_java_tutorials

import com.google.gson.JsonObject
import io.reactivex.rxjava3.core.Observable
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("https://www.7timer.info/bin/astro.php?lon=113.2&lat=23.1&ac=0&unit=metric&output=json&tzshift=0")
    fun getResponseData(): Observable<ResponseApi>

    companion object {
        const val BASE_URL = "https://www.7timer.info/bin/astro.php/"
    }
}