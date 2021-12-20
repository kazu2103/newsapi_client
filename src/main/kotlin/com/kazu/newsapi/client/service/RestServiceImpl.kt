package com.kazu.newsapi.client.service

import com.kazu.newsapi.client.model.NewsApiRequestModel
import com.kazu.newsapi.client.model.NewsApiResponseModel
import com.kazu.newsapi.client.repository.dao.ArticleDao
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@Service
class RestServiceImpl(private val restTemplate: RestTemplate) : RestService {

    @Value("\${newsapi.client.apikey}")
    lateinit var apikey: String

    @Value("\${newsapi.client.url}")
    lateinit var url: String

    override fun callEverythingApi(): String{

        val requestModel: NewsApiRequestModel = NewsApiRequestModel(
            apiKey = apikey
        )
        val response: NewsApiResponseModel? = restTemplate.getForObject(url, NewsApiResponseModel::class.java)

        if (response == null){
            return "result was not found."
        }
        else if ( !"ok".equals(response.status)) {
            return "response.status is error, code[${response.code}], message[${response.code}]"
        }

        for(a in response.articles!!){
            transaction {
                val article = ArticleDao.new {
                    sourceId = a.source.id
                    sourceName = a.source.name
                    author = a.author
                    title = a.title
                    description = a.description
                    url = a.url
                    urlToImage = a.urlToImage
                    publishAt = LocalDateTime.parse(a.publishedAt, DateTimeFormatter.ISO_DATE_TIME)
                    content = a.content
                    creDate = LocalDateTime.now()
                    creUserId = "RestService"
                    updDate = LocalDateTime.now()
                    updUserId = "RestService"
                }
            }
        }
        return response.toString()
    }

}