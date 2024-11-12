package com.test.data.mapper

import com.test.data.model.OwnerDto
import com.test.domain.model.OwnerEntity

fun OwnerDto.toEntity() = OwnerEntity(
  avatarUrl = this.avatarUrl.orEmpty()
)
