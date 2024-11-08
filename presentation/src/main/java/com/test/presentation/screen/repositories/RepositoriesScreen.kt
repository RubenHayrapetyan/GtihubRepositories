package com.test.presentation.screen.repositories

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.test.presentation.R
import com.test.presentation.screen.repositories.components.Repositories

@Composable
fun RepositoriesScreen(
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
      Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
      ) {
        Text(
          text = state.errorMessage,
          color = colorResource(R.color.error_message)
        )
        Button(onClick = {
          onEvent(RepositoriesContract.RepositoriesEvent.GetRepositories)
        }) {
          Text(
            text = stringResource(R.string.retry),
          )
        }
      }
    }

    if (state.isLoading) {
      CircularProgressIndicator()
    }

    if (state.repositories.isNotEmpty()) {
      Repositories(repositories = state.repositories)
    }
  }
}

@Preview(showBackground = true)
@Composable
fun RepositoriesScreenPreview() {

}