package com.example.api.di


import android.content.Context
import com.example.api.BuildConfig
import com.example.api.data.database.AppDatabase
import com.example.api.data.database.dao.MovieDao
import com.example.api.data.remote.ApiService
import com.example.api.data.remote.RemoteDataSource
import com.example.api.data.repository.MovieRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    private val gson =GsonBuilder()
        .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
        .serializeNulls()
        .create()

    @Singleton
    @Provides
    fun providesOkHttpClient(): OkHttpClient =
        if (BuildConfig.DEBUG){
            val httpLoggingInterceptor = HttpLoggingInterceptor()
            httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BODY

                OkHttpClient.Builder()
                    .addInterceptor(httpLoggingInterceptor)
                    .build()
        } else{
            OkHttpClient.Builder()
                .build()
        }
    @Singleton
    @Provides
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(BuildConfig.BASE_URL)
        .client(okHttpClient)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
    @Singleton
    @Provides
    fun providesApiService(retrofit: Retrofit): ApiService =retrofit.create(ApiService::class.java)

    @Singleton
    @Provides
    fun providesRemoteDataSource(apiService: ApiService) = RemoteDataSource(apiService)

    @Singleton
    @Provides
    fun provideDatabase(@ApplicationContext appContext: Context) = AppDatabase.getDatabase(appContext)

    @Singleton
    @Provides
    fun providesMoviesDao(db: AppDatabase) = db.movieDao()

    @Singleton
    @Provides

    fun providesMovieRepository(localDataSource: MovieDao, remoteDataSource: RemoteDataSource) =
        MovieRepository(localDataSource,RemoteDataSource)
}