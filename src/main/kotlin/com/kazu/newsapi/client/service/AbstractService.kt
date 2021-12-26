package com.kazu.newsapi.client.service

abstract class AbstractService(
    var resultMap: MutableMap<String, String>,
    val resultStatusStr: String = "status",
    val resultMessageStr: String = "message",
) {
}