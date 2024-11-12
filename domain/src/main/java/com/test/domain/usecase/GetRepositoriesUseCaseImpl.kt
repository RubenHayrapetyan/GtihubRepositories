package com.test.domain.usecase

import com.test.core.util.ActionResult
import com.test.domain.model.GithubRepositoriesItemEntity
import com.test.domain.repository.GithubRepositoriesRepository
import javax.inject.Inject

class GetRepositoriesUseCaseImpl @Inject constructor(
  private val githubRepositoriesRepository: GithubRepositoriesRepository
) : GetRepositoriesUseCase {
  override suspend fun invoke(): ActionResult<List<GithubRepositoriesItemEntity>> =
    githubRepositoriesRepository.getRepositories()
}