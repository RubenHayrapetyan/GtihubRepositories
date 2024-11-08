package com.test.githubrepositories.di

import com.test.data.remote.GithubRepositoriesService
import com.test.githubrepositories.util.AppConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {

  @Provides
  @Singleton
  fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder().apply {
    readTimeout(1, TimeUnit.MINUTES)
    connectTimeout(1, TimeUnit.MINUTES)
    callTimeout(1, TimeUnit.MINUTES)
    writeTimeout(1, TimeUnit.MINUTES)
  }.build()

  @Provides
  @Singleton
  fun provideRetrofit(
    okHttpClient: OkHttpClient,
  ): Retrofit = Retrofit.Builder().apply {
    baseUrl(AppConstants.BASE_URL)
    addConverterFactory(MoshiConverterFactory.create())
    client(okHttpClient)
  }.build()

  @Provides
  @Singleton
  fun provideGithubRepositoriesService(retrofit: Retrofit): GithubRepositoriesService =
    retrofit.create(GithubRepositoriesService::class.java)
}