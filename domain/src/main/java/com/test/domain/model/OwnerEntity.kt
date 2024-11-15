package com.test.domain.model

data class OwnerEntity(
  val avatarUrl: String
) {
  companion object {
    val emptyOwner = OwnerEntity(
      avatarUrl = ""
    )
  }
}