package com.test.presentation.screen.repositories

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.domain.usecase.GetRepositoriesUseCase
import com.test.core.util.ActionResult
import com.test.presentation.mapper.toUiModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(
  private val getRepositoriesUseCase: GetRepositoriesUseCase
): ViewModel() {

  var productsState by mutableStateOf(RepositoriesContract.RepositoriesState())
    private set

  fun onGithubRepositoriesEvent(event: RepositoriesContract.RepositoriesEvent) {
    when (event) {
      is RepositoriesContract.RepositoriesEvent.GetRepositories -> {
        getRepositories()
      }
    }
  }

  private fun getRepositories() {
    viewModelScope.launch {
      productsState = productsState.copy(
        isLoading = true,
        errorMessage = ""
      )

      productsState = when (val result = getRepositoriesUseCase()) {
        is ActionResult.Success -> {
          val githubRepositories = result.data.map { it.toUiModel() }
          productsState.copy(
            repositories = githubRepositories,
            errorMessage = "",
            isLoading = false,
          )
        }

        is ActionResult.Error -> {
          productsState.copy(
            isLoading = false,
            errorMessage = result.e.message ?: "Unknown error"
          )
        }
      }
    }
  }
}