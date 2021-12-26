package com.kazu.newsapi.client

import com.kazu.newsapi.client.repository.dao.ArticleDao
import com.kazu.newsapi.client.service.RestService
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import java.time.LocalDateTime

@Controller
class TestController {

    @Autowired
    lateinit var restService: RestService

    @GetMapping("/")
    @ResponseBody
    fun index(): String {
        transaction {
            val article = ArticleDao.new {
                sourceId = "text"
                sourceName = "text"
                author = "text"
                title = "text"
                description = "text"
                url = "text"
                urlToImage = "text"
                publishAt = LocalDateTime.now()
                content = "text"
                creDate = LocalDateTime.now()
                creUserId = "text"
                updDate = LocalDateTime.now()
                updUserId = "text"
            }
        }

        return "${ArticleDao.all()}"
    }

    @GetMapping("/send")
    @ResponseBody
    fun sendRequest(): String?{
        return restService.callEverythingApi().get("status")
    }
}