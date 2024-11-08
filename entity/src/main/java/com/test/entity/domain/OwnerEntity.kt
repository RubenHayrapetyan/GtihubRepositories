package com.test.entity.domain

data class OwnerEntity(
  val avatarUrl: String
) {
  companion object {
    val emptyOwner = OwnerEntity(
      avatarUrl = ""
    )
  }
}