package com.test.presentation.mapper

import com.test.domain.toDDmmYYYYhhmm
import com.test.domain.model.GithubRepositoriesItemEntity

fun GithubRepositoriesItemEntity.toUiModel() =
  com.test.presentation.model.GithubRepositoriesItemUiModel(
    id = this.id,
    name = this.name,
    description = this.description,
    created = this.created.toDDmmYYYYhhmm(),
    ownerUiModel = this.ownerEntity.toUiModel()
  )