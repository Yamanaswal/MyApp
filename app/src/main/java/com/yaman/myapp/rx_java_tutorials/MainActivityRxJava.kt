package com.yaman.myapp.rx_java_tutorials

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.JsonObject
import com.yaman.myapp.R
import com.yaman.myapp.rx_java_tutorials.ApiService.Companion.BASE_URL
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.json.JSONArray
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory


class MainActivityRxJava : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_rx_java)

        val interceptor = HttpLoggingInterceptor()
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client: OkHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()


        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addConverterFactory(ScalarsConverterFactory.create())
            .client(client)
            .build()

        val service = retrofit.create(ApiService::class.java)

        val res = service.getResponseData()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                Log.e("Response", "onCreate: Product: " + it.product)
            },{
                Log.e("Error: ", "onCreate: " + it.localizedMessage)
            })

        res.dispose()

//        service.getResponseData().enqueue(object : Callback<JsonObject> {
//            override fun onResponse(call: Call<JsonObject>, response: Response<JsonObject>) {
//                Log.e("TAG", "onResponse: ${response.body()}}")
//                Toast.makeText(this@MainActivityRxJava, "${response.body()}\"", Toast.LENGTH_SHORT)
//                    .show()
//
//                val res = response.body()
//                val dataseries = res?.getAsJsonArray("dataseries")
//                val data = dataseries?.get(0) as JsonObject
//                val transparency = data.get("transparency")
//                Log.e("Data: ", "onResponse: $transparency")
//            }
//
//            override fun onFailure(call: Call<JsonObject>, t: Throwable) {
//                Log.e("TAG", "onFailure: ${t.localizedMessage}")
//                Toast.makeText(
//                    this@MainActivityRxJava,
//                    "${t.localizedMessage}\"",
//                    Toast.LENGTH_SHORT
//                ).show()
//            }
//        })


/*        service.getResponseData().enqueue(object : Callback<JSONObject> {
            override fun onResponse(call: Call<JSONObject>, response: Response<JSONObject>) {
                Log.e("TAG", "onResponse: ${response.body()}}")
                Toast.makeText(this@MainActivityRxJava, "${response.body()}\"", Toast.LENGTH_SHORT)
                    .show()

                val res = response.body()
                val dataseries = res?.getJSONArray("dataseries")
                val data = dataseries?.get(0) as JsonObject
//                val transparency = data.get("transparency")
//                Log.e("Data: ", "onResponse: $transparency")
            }

            override fun onFailure(call: Call<JSONObject>, t: Throwable) {
                Log.e("TAG", "onFailure: ${t.localizedMessage}")
                Toast.makeText(
                    this@MainActivityRxJava,
                    "${t.localizedMessage}\"",
                    Toast.LENGTH_SHORT
                ).show()
            }
        })*/
    }

    fun handleResponse(){

    }

    fun handleError(){

    }
}