package com.test.domain.usecase

import com.test.entity.ui.GithubRepositoriesItemUiModel
import com.test.entity.util.ActionResult

interface GetRepositoriesUseCase {

  suspend operator fun invoke(): ActionResult<List<GithubRepositoriesItemUiModel>>
}