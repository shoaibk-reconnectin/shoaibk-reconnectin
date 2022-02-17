package com.sk2apps.storywall.network

import android.util.Base64
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class RetrofitClient {
    companion object{
        private val AUTH = "Basic " + Base64.encodeToString("shoaibkhan:123456".toByteArray(), Base64.NO_WRAP)
        private const val BASE_URL = "https://api.themoviedb.org/3/movie/"

        fun getApi(): APIService {
            val okHttpClient: OkHttpClient = OkHttpClient.Builder()
                .addInterceptor(object : Interceptor {
                    @Throws(IOException::class)
                    override fun intercept(chain: Interceptor.Chain): Response {
                        val original: Request = chain.request()
                        val requestBuilder: Request.Builder = original.newBuilder()
                            .addHeader("Authorization", AUTH)
                            .method(original.method, original.body)
                        val request: Request = requestBuilder.build()
                        return chain.proceed(request)
                    }
                }
                ).build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build().create(APIService::class.java)
        }
    }
}