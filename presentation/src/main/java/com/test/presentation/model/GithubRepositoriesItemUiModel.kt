package com.test.presentation.model

data class GithubRepositoriesItemUiModel(
  val id: Long = -1,
  val name: String = "",
  val description: String = "",
  val created: String = "",
  val ownerUiModel: OwnerUiModel = OwnerUiModel()
)