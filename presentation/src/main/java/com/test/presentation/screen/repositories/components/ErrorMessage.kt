package com.test.presentation.screen.repositories.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.test.presentation.R

@Composable
internal fun ErrorMessage(modifier: Modifier = Modifier, errorMessage: String, retryClick: () -> Unit) {
  Column(
    modifier = Modifier.fillMaxWidth(),
    horizontalAlignment = Alignment.CenterHorizontally
  ) {
    Text(
      text = errorMessage,
      color = colorResource(R.color.error_message)
    )
    Button(onClick = {
      retryClick()
    }) {
      Text(
        text = stringResource(R.string.retry),
      )
    }
  }
}