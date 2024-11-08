package com.test.domain.mapper

import com.test.domain.toDDmmYYYYhhmm
import com.test.entity.domain.GithubRepositoriesItemEntity
import com.test.entity.ui.GithubRepositoriesItemUiModel

fun GithubRepositoriesItemEntity.toUiModel() = GithubRepositoriesItemUiModel(
  id = this.id,
  name = this.name,
  description = this.description,
  created = this.created.toDDmmYYYYhhmm(),
  ownerUiModel = this.ownerEntity.toUiModel()
)