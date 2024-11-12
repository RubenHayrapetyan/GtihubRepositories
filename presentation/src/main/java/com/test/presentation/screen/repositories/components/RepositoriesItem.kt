package com.test.presentation.screen.repositories.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.test.presentation.model.GithubRepositoriesItemUiModel
import com.test.presentation.R

@Composable
internal fun RepositoriesItem(
  repositoryItem: GithubRepositoriesItemUiModel,
  modifier: Modifier = Modifier
) {
  Card(
    modifier = modifier
      .fillMaxWidth()
      .padding(8.dp),
    colors = CardDefaults.cardColors(
      colorResource(R.color.repos_card_bg)
    ),
    shape = RoundedCornerShape(8.dp),
    elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
  ) {
    Column(modifier = Modifier.padding(4.dp)) {

      Row(
        modifier = Modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically
      ) {
        AsyncImage(
          model = repositoryItem.ownerUiModel.avatarUrl,
          contentDescription = "Avatar",
        )
        TextDescriptionAndDate(repositoryItem)
      }
    }
  }
}

@Composable
private fun TextDescriptionAndDate(repositoryItem: GithubRepositoriesItemUiModel) {
  Column {
    Text(
      text = stringResource(R.string.name_format, repositoryItem.name),
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
      text = stringResource(R.string.description_format, repositoryItem.description)
    )
    Spacer(modifier = Modifier.height(4.dp))
    Text(
      maxLines = 1,
      overflow = TextOverflow.Ellipsis,
      text = stringResource(R.string.date_format, repositoryItem.created)
    )
  }
}

@Preview
@Composable
internal fun RepositoriesItemPreview() {
  RepositoriesItem(
    repositoryItem = GithubRepositoriesItemUiModel(
      id = 1,
      name = "Name",
      description = "Description",
    )
  )
}