package com.test.presentation.screen.repositories

import com.test.presentation.model.GithubRepositoriesItemUiModel

class RepositoriesContract {
  data class RepositoriesState(
    val repositories: List<GithubRepositoriesItemUiModel> = emptyList(),
    val errorMessage: String = "",
    val isLoading: Boolean = false,
  )

  sealed class RepositoriesEvent {
    data object GetRepositories : RepositoriesEvent()
  }
}