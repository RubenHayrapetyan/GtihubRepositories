package com.test.data.model.mapper

import com.test.entity.domain.OwnerEntity

fun com.test.entity.dto.OwnerDto.toEntity() = OwnerEntity(
  avatarUrl = this.avatarUrl.orEmpty()
)
