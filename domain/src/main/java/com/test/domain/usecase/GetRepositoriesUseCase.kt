package com.test.domain.usecase

import com.test.core.util.ActionResult
import com.test.domain.model.GithubRepositoriesItemEntity

interface GetRepositoriesUseCase {

  suspend operator fun invoke(): ActionResult<List<GithubRepositoriesItemEntity>>
}