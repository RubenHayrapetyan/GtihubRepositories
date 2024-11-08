package com.test.data.model.mapper

import com.test.entity.dto.GithubRepositoriesItemDto
import com.test.entity.domain.GithubRepositoriesItemEntity
import com.test.entity.domain.OwnerEntity

fun GithubRepositoriesItemDto.toEntity() = GithubRepositoriesItemEntity(
    id = this.id ?: -1,
    name = this.name.orEmpty(),
    description = this.description.orEmpty(),
    created = this.created.orEmpty(),
    ownerEntity = this.ownerDto?.toEntity() ?: OwnerEntity.emptyOwner
)