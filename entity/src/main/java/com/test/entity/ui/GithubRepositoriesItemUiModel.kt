package com.test.entity.ui

data class GithubRepositoriesItemUiModel(
  val id: Long = -1,
  val name: String = "",
  val description: String = "",
  val created: String = "",
  val ownerUiModel: OwnerUiModel = OwnerUiModel()
)