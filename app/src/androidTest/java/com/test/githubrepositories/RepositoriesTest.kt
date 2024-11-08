package com.test.githubrepositories

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.onNodeWithText
import com.test.entity.ui.GithubRepositoriesItemUiModel
import com.test.presentation.screen.repositories.components.Repositories
import org.junit.Rule
import org.junit.Test

class RepositoriesTest {

  @get:Rule
  val composeTestRule = createComposeRule()

  @Test
  fun repositoriesList_displaysRepositoryItems() {
    // Sample data to pass into the Repositories composable
    val repositories = listOf(
      GithubRepositoriesItemUiModel(name = "Repo 1", description = "Description 1"),
      GithubRepositoriesItemUiModel(name = "Repo 2", description = "Description 2"),
      GithubRepositoriesItemUiModel(name = "Repo 3", description = "Description 3")
    )

    // Set the composable content
    composeTestRule.setContent {
      Repositories(repositories = repositories)
    }

    // Check if all repository names are displayed
    repositories.forEach { repository ->
      composeTestRule.onNodeWithText(repository.name).assertIsDisplayed()
    }

    // Optionally, you can verify other UI elements like descriptions if necessary
    repositories.forEach { repository ->
      composeTestRule.onNodeWithText(repository.description).assertIsDisplayed()
    }
  }
}
