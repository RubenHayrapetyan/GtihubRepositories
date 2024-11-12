package com.test.data.repository

import com.test.core.util.ActionResult
import com.test.data.mapper.toEntity
import com.test.data.remote.GithubRepositoriesService
import com.test.data.util.makeApiCall
import com.test.domain.repository.GithubRepositoriesRepository
import com.test.domain.model.GithubRepositoriesItemEntity
import javax.inject.Inject

class GithubRepositoriesRepositoryImpl @Inject constructor(
  private val githubRepositoriesService: GithubRepositoriesService
) : GithubRepositoriesRepository {

  override suspend fun getRepositories(): ActionResult<List<GithubRepositoriesItemEntity>> =
    makeApiCall {
      githubRepositoriesService.getRepositories().map { it.toEntity() }
    }
}