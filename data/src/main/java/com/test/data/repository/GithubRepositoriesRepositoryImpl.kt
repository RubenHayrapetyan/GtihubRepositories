package com.test.data.repository

import com.test.data.model.mapper.toEntity
import com.test.data.remote.GithubRepositoriesService
import com.test.data.util.makeApiCall
import com.test.domain.repository.GithubRepositoriesRepository
import com.test.entity.domain.GithubRepositoriesItemEntity
import com.test.entity.util.ActionResult
import javax.inject.Inject

class GithubRepositoriesRepositoryImpl @Inject constructor(
  private val githubRepositoriesService: GithubRepositoriesService
) : GithubRepositoriesRepository {

  override suspend fun getRepositories(): ActionResult<List<GithubRepositoriesItemEntity>> =
    makeApiCall {
      githubRepositoriesService.getRepositories().map { it.toEntity() }
    }
}