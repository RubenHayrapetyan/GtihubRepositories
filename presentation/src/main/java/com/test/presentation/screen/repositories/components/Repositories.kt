package com.test.presentation.screen.repositories.components

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.test.entity.ui.GithubRepositoriesItemUiModel

@Composable
internal fun Repositories(repositories: List<GithubRepositoriesItemUiModel>) {
  LazyColumn(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    items(
      count = repositories.size,
      key = { index -> repositories[index].id }
    ) { index ->
      RepositoriesItem(repositoryItem = repositories[index])
    }
  }
}

@Preview
@Composable
internal fun RepositoriesPreview() {
  val repositories = List(20) { index ->
    GithubRepositoriesItemUiModel(
      id = (index + 1).toLong(),
      name = "Name${index + 1}",
      description = "Description${index + 1}"
    )
  }
  Repositories(repositories = repositories)
}