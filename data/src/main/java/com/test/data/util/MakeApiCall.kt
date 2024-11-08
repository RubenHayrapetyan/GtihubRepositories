package com.test.data.util

import com.test.entity.util.ActionResult

suspend fun <R> makeApiCall(call: suspend () -> R) = try {
  ActionResult.Success(data = call())
} catch (e: Exception) {
  ActionResult.Error(e = e)
}