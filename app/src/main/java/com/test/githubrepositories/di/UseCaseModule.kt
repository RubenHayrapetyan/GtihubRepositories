package com.test.githubrepositories.di

import com.test.domain.usecase.GetRepositoriesUseCase
import com.test.domain.usecase.GetRepositoriesUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
internal abstract class UseCaseModule {
  @Binds
  abstract fun bindGetRepositoriesUseCase(useCase: GetRepositoriesUseCaseImpl): GetRepositoriesUseCase
}