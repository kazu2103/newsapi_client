package com.kazu.newsapi.client.service

interface RestService {
    fun callEverythingApi(): Map<String, String>
}