package com.naze.common.di

import com.google.gson.GsonBuilder
import com.umc.bondingwizards.data.remote.api.DummyApi
import com.umc.bondingwizards.data.remote.api.EventApi
import com.umc.bondingwizards.data.remote.api.FriendApi
import com.umc.bondingwizards.data.remote.api.PresentApi
import com.umc.bondingwizards.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {

    private var gson = GsonBuilder()
        .setLenient()
        .create()

    @Provides
    @Singleton
    fun provideApiService(): EventApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            //.client(okHttpClient(AppInterceptor())) //Interceptor 필요할 때
            .build()
            .create(EventApi::class.java)
    }

    @Provides
    @Singleton
    fun providePresentApiService(): PresentApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            //.client(okHttpClient(AppInterceptor())) //Interceptor 필요할 때
            .build()
            .create(PresentApi::class.java)
    }

    @Provides
    @Singleton
    fun provideFriendApiService():FriendApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            //.client(okHttpClient(AppInterceptor())) //Interceptor 필요할 때
            .build()
            .create(FriendApi::class.java)
    }




    @Provides
    @Singleton
    fun okHttpClient(interceptor: AppInterceptor) : OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            }).build()
    }

    class AppInterceptor: Interceptor {
        @Throws(IOException::class)
        override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
            val accessToken = "" //App.prefs.getString("accessToken","")
            val newRequest = request().newBuilder()
                .addHeader("Authorization",accessToken)
                .build()
            proceed(newRequest)
        }
    }
}