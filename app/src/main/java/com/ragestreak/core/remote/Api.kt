package com.ragestreak.core.remote

import com.ragestreak.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class Api {

    class Factory {
        companion object {

            inline fun <reified T> newInstance(): T {
                val okHttpClient = getOkHttpClient()
                val retrofit = getRetrofit(okHttpClient)
                return retrofit.create(T::class.java)
            }

            fun getRetrofit(okHttpClient: OkHttpClient): Retrofit {
                val builder = Moshi.Builder()
                    .add(KotlinJsonAdapterFactory())
                    .build()

                return Retrofit.Builder()
                    .baseUrl(BuildConfig.API_BASE_URL)
                    .addConverterFactory(MoshiConverterFactory.create(builder))
                    .client(okHttpClient)
                    .build()
            }

            fun getOkHttpClient(): OkHttpClient {
                return OkHttpClient.Builder().build()
            }

        }
    }

}