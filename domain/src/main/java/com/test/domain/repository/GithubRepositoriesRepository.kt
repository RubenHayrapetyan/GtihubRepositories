package com.test.domain.repository

import com.test.core.util.ActionResult
import com.test.domain.model.GithubRepositoriesItemEntity

interface GithubRepositoriesRepository {

  suspend fun getRepositories(): ActionResult<List<GithubRepositoriesItemEntity>>
}