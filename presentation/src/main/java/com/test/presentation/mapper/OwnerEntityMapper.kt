package com.test.presentation.mapper

import com.test.domain.model.OwnerEntity

fun OwnerEntity.toUiModel() = com.test.presentation.model.OwnerUiModel(
  avatarUrl = this.avatarUrl
)