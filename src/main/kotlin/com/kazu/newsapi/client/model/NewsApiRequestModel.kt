package com.kazu.newsapi.client.model

import com.fasterxml.jackson.annotation.JsonIgnore
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonProperty
import org.jetbrains.annotations.NotNull
import org.jetbrains.annotations.Nullable

data class NewsApiRequestModel(

    @JsonProperty("apiKey")
    @NotNull
    val apiKey: String,

    @JsonProperty("q")
    val keyword: String? = null,

    @JsonProperty("qInTitle")
    val keywordInTitle: String? = null,

    @JsonProperty("sources")
    val sources: String? = null,

    @JsonProperty("domains")
    val domains: String? = null,

    @JsonProperty("excludeDomains")
    val excludeDomains: String? = null,

    @JsonProperty("from")
    val from: String? = null,

    @JsonProperty("to")
    val to: String? = null,

    @JsonProperty("language")
    val language: String? = null,

    @JsonProperty("sortBy")
    val sortBy: String? = null,

    @JsonProperty("apiKey")
    val pageSize: String? = null,

    @JsonProperty("page")
    val page: String? = null,
)