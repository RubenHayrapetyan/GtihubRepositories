package com.test.data.mapper

import com.test.data.model.GithubRepositoriesItemDto
import com.test.domain.model.GithubRepositoriesItemEntity
import com.test.domain.model.OwnerEntity

fun GithubRepositoriesItemDto.toEntity() = GithubRepositoriesItemEntity(
    id = this.id ?: -1,
    name = this.name.orEmpty(),
    description = this.description.orEmpty(),
    created = this.created.orEmpty(),
    ownerEntity = this.ownerDto?.toEntity() ?: OwnerEntity.emptyOwner
)