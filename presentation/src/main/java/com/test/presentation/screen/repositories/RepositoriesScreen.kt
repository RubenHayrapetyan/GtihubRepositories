package com.test.presentation.screen.repositories

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.test.presentation.screen.repositories.components.ErrorMessage
import com.test.presentation.screen.repositories.components.Repositories

@Composable
internal fun RepositoriesScreen(
  state: RepositoriesContract.RepositoriesState,
  onEvent: (RepositoriesContract.RepositoriesEvent) -> Unit,
  modifier: Modifier = Modifier
) {
  LaunchedEffect(Unit) {
    onEvent(RepositoriesContract.RepositoriesEvent.GetRepositories)
  }

  Box(
    modifier = modifier
      .fillMaxSize()
      .padding(8.dp),
    contentAlignment = Alignment.Center
  ) {
    if (state.errorMessage.isNotEmpty()) {
      ErrorMessage(
        modifier = Modifier.fillMaxWidth(),
        errorMessage = state.errorMessage,
        retryClick = {
          onEvent(RepositoriesContract.RepositoriesEvent.GetRepositories)
        }
      )
    }

    if (state.isLoading) {
      CircularProgressIndicator()
    }

    if (state.repositories.isNotEmpty()) {
      Repositories(repositories = state.repositories)
    }
  }
}