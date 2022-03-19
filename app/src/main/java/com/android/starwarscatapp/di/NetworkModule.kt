package com.android.starwarscatapp.di

import com.android.starwarscatapp.rest.RequestInterceptor
import com.android.starwarscatapp.rest.StarWarsApi
import com.android.starwarscatapp.rest.StarWarsRepository
import com.android.starwarscatapp.rest.StarWarsRepositoryImpl
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule {

    @Provides
    fun providesGson() = Gson()

    @Provides
    fun providesLoggingInterceptor() = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    fun providesRequestInterceptor() = RequestInterceptor()

    @Provides
    fun providesOkHttpClient(
        requestInterceptor: RequestInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(requestInterceptor)
            .addInterceptor(loggingInterceptor)
            .connectTimeout(30, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @Singleton
    fun providesRetrofitService(okHttpClient: OkHttpClient, gson: Gson): StarWarsApi {
        return Retrofit.Builder()
            .baseUrl(StarWarsApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build()
            .create(StarWarsApi::class.java)
    }

    @Provides
    fun providesStarWarsRepository(starWarsApi: StarWarsApi): StarWarsRepository {
        return StarWarsRepositoryImpl(starWarsApi)
    }
}