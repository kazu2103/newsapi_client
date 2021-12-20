package com.kazu.newsapi.client.model

import com.fasterxml.jackson.annotation.JsonProperty

data class NewsApiResponseModel(

    @JsonProperty("status")
    val status: String,

    @JsonProperty("totalResults")
    val totalResults: Int?,

    @JsonProperty("articles")
    val articles: List<Article>?,

    // in the case of error
    @JsonProperty("code")
    val code: String?,

    // in the case of error
    @JsonProperty("message")
    val message: String?,

)

data class Article(

    @JsonProperty("source")
    val source: Source,

    @JsonProperty("author")
    val author: String?,

    @JsonProperty("title")
    val title: String?,

    @JsonProperty("description")
    val description: String?,

    @JsonProperty("url")
    val url: String,

    @JsonProperty("urlToImage")
    val urlToImage: String?,

    @JsonProperty("publishedAt")
    val publishedAt: String?,

    @JsonProperty("content")
    val content: String?,

)

data class Source(

    @JsonProperty("id")
    val id: String?,

    @JsonProperty("name")
    val name: String?,

)