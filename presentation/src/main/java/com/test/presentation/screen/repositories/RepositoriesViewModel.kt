package com.test.presentation.screen.repositories

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.domain.usecase.GetRepositoriesUseCase
import com.test.entity.util.ActionResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RepositoriesViewModel @Inject constructor(
  private val getRepositoriesUseCase: GetRepositoriesUseCase
): ViewModel() {

  var productsState by mutableStateOf(RepositoriesContract.RepositoriesState())
    private set

  fun onProductsEvent(event: RepositoriesContract.RepositoriesEvent) {
    when (event) {
      is RepositoriesContract.RepositoriesEvent.GetRepositories -> {
        getRepositories()
      }
    }
  }

  private fun getRepositories() {
    viewModelScope.launch {
      productsState = productsState.copy(isLoading = true)

      productsState = when (val result = getRepositoriesUseCase()) {
        is ActionResult.Success -> {
          productsState.copy(
            repositories = result.data,
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