package com.rud.basetamplate.misc.ext

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Job

fun launchAsync(block: suspend CoroutineScope.() -> Unit): Job {
    return launchAsync {  block() }
}

suspend fun <T> async(block: suspend CoroutineScope.() -> T): Deferred<T> {
    return async { block() }
}

suspend fun <T> asyncAwait(block: suspend CoroutineScope.() -> T): T {
    return async(block).await()
}