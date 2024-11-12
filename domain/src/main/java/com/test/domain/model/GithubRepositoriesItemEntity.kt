package com.test.domain.model

data class GithubRepositoriesItemEntity(
  val id: Long,
  val name: String,
  val description: String,
  val created: String,
  val ownerEntity: OwnerEntity
)
