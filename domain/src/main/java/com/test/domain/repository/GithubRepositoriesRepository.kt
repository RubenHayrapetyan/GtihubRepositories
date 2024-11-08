package com.test.domain.repository

import com.test.entity.domain.GithubRepositoriesItemEntity
import com.test.entity.util.ActionResult

interface GithubRepositoriesRepository {

  suspend fun getRepositories(): ActionResult<List<GithubRepositoriesItemEntity>>
}