package com.test.data.model

import com.squareup.moshi.Json

data class GithubRepositoriesItemDto(
  val id: Long? = null,
  val description: String? = null,
  val name: String? = null,
  @field:Json(name = "created_at")
  val created: String? = null,
  @field:Json(name = "owner")
  val ownerDto: OwnerDto? = null,
)