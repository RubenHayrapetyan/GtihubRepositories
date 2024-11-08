package com.test.domain

import com.test.domain.mapper.toUiModel
import com.test.domain.repository.GithubRepositoriesRepository
import com.test.domain.usecase.GetRepositoriesUseCaseImpl
import com.test.entity.domain.GithubRepositoriesItemEntity
import com.test.entity.util.ActionResult
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetRepositoriesUseCaseImplTest {
  private val githubRepositoriesRepository = mockk<GithubRepositoriesRepository>()
  private val useCase = GetRepositoriesUseCaseImpl(githubRepositoriesRepository)

  @Test
  fun `should return success when repository returns success`() = runTest {
    val expectedData = listOf<GithubRepositoriesItemEntity>()
    coEvery { githubRepositoriesRepository.getRepositories() } returns ActionResult.Success(
      expectedData
    )

    when (val result = useCase()) {
      is ActionResult.Success -> {
        assert(result.data == expectedData.map { it.toUiModel() })
      }

      is ActionResult.Error -> assert(false) { "Expected success but got error" }
    }
  }

  @Test
  fun `should return error when repository returns error`() = runTest {
    val expectedException = Exception("Test exception")
    coEvery { githubRepositoriesRepository.getRepositories() } returns ActionResult.Error(
      expectedException
    )

    when (val result = useCase()) {
      is ActionResult.Success -> assert(false) { "Expected error but got success" }
      is ActionResult.Error -> {
        assert(result.e == expectedException) { "Expected the same exception to be returned" }
      }
    }
  }
}