package com.test.domain.mapper

import com.test.entity.domain.OwnerEntity
import com.test.entity.ui.OwnerUiModel

fun OwnerEntity.toUiModel() = OwnerUiModel(
  avatarUrl = this.avatarUrl
)