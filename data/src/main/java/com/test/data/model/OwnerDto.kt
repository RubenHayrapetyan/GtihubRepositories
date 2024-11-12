package com.test.data.model

import com.squareup.moshi.Json

data class OwnerDto(
  @field:Json(name = "avatar_url")
  val avatarUrl: String? = null,
)