package com.test.domain.usecase

import com.test.domain.mapper.toUiModel
import com.test.domain.repository.GithubRepositoriesRepository
import com.test.entity.ui.GithubRepositoriesItemUiModel
import com.test.entity.util.ActionResult
import javax.inject.Inject

class GetRepositoriesUseCaseImpl @Inject constructor(
  private val githubRepositoriesRepository: GithubRepositoriesRepository
) : GetRepositoriesUseCase {
  override suspend fun invoke(): ActionResult<List<GithubRepositoriesItemUiModel>> {
    return when (val result = githubRepositoriesRepository.getRepositories()) {
      is ActionResult.Success -> {
        ActionResult.Success(result.data.map { it.toUiModel() })
      }

      is ActionResult.Error -> {
        ActionResult.Error(result.e)
      }
    }
  }
}