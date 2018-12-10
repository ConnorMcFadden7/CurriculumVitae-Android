package com.curriculumvitae.android.di.module

import com.curriculumvitae.android.BuildConfig
import com.curriculumvitae.android.data.api.ApiConfig
import com.curriculumvitae.android.di.scope.PerApplication
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    @Provides
    @PerApplication
    fun provideGsonBuilder(): GsonBuilder {
        return GsonBuilder()
    }

    @Provides
    @PerApplication
    fun provideGson(gsonBuilder: GsonBuilder): Gson {
        return gsonBuilder.create()
    }

    @Provides
    @PerApplication
    fun provideHttpClientBuilder(): OkHttpClient.Builder {
        val okHttpClientBuilder = OkHttpClient.Builder()
        okHttpClientBuilder.connectTimeout(TIMEOUT_CONNECTION.toLong(), TimeUnit.SECONDS)
        okHttpClientBuilder.readTimeout(TIMEOUT_READ, TimeUnit.SECONDS)
        return okHttpClientBuilder
    }

    @Provides
    @PerApplication
    fun provideHttpClient(httpClientBuilder: OkHttpClient.Builder): OkHttpClient {
        return httpClientBuilder.build()
    }

    @Provides
    @PerApplication
    fun provideRetrofitBuilder(
        @PerApplication httpClient: OkHttpClient, @PerApplication gson: Gson
    ): Retrofit.Builder {
        return Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(httpClient)
    }

    @Provides
    @PerApplication
    fun provideRetrofit(
        retrofitBuilder: Retrofit.Builder,
        @PerApplication httpClient: OkHttpClient
    ): Retrofit {
        return retrofitBuilder.baseUrl(ApiConfig.API_BASE_URL).client(httpClient).build()
    }

    companion object {

        val TIMEOUT_CONNECTION = if (BuildConfig.DEBUG) 60 else 15
        val TIMEOUT_READ: Long = 20
    }
}
