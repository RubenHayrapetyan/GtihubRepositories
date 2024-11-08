package com.test.githubrepositories.di

import com.test.data.repository.GithubRepositoriesRepositoryImpl
import com.test.domain.repository.GithubRepositoriesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class RepositoryModule {
  @Binds
  abstract fun bindGithubRepositoriesRepository(repository: GithubRepositoriesRepositoryImpl)
      : GithubRepositoriesRepository
}