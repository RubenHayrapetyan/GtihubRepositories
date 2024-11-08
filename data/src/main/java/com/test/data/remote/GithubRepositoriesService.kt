package com.test.data.remote

import com.test.entity.dto.GithubRepositoriesItemDto
import com.test.data.util.DataConstants
import com.test.entity.util.ActionResult
import retrofit2.http.GET

interface GithubRepositoriesService {

  @GET(DataConstants.ORGANIZATION_REPOS)
  suspend fun getRepositories(): List<GithubRepositoriesItemDto>
}
