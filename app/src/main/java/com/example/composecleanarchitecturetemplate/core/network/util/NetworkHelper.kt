package com.example.composecleanarchitecturetemplate.core.network.util

suspend fun <T> processResponse(action: suspend () -> T?): T {
    return action() ?: throw Exception("Empty")
}