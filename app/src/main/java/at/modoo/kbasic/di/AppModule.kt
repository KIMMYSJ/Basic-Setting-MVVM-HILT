package at.modoo.kbasic.di

import at.modoo.kbasic.common.Common
import at.modoo.kbasic.network.BlogAPI
import at.modoo.kbasic.repository.RedditRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideLoggingInterceptor(): OkHttpClient {
        val builder =  OkHttpClient.Builder()
        val loggingInterceptor =  HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
        builder.networkInterceptors().add(loggingInterceptor)
        return builder.build()
    }

    @Singleton
    @Provides
    fun provideBlogApi(client:OkHttpClient):BlogAPI = Retrofit.Builder().baseUrl(Common.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create()).client(client).build()
        .create(BlogAPI::class.java)
    @Singleton
    @Provides
    fun provideRedditRepositiory(api:BlogAPI):RedditRepository = RedditRepository(api)

}