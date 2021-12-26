package com.kazu.newsapi.client.repository.table

import org.jetbrains.exposed.dao.id.IntIdTable
import org.jetbrains.exposed.sql.javatime.datetime

object ArticleTable: IntIdTable("T_ARTICLE") {
 val sourceId = varchar("sourceId", 50).nullable()
 val sourceName = varchar("sourceName", 50).nullable()
 val author = varchar("author", 255).nullable()
 val title = varchar("title", 255).nullable()
 val description = text("description").nullable()
 val url = varchar("url", 255)
 val urlToImage = varchar("urlToImage", 255).nullable()
 val publishAt = datetime("publishAt").nullable()
 val content = text("content").nullable()
 val creDate = datetime("creDate")
 val creUserId = varchar("creUserId", 50)
 val updDate = datetime("updDate")
 val updUserId = varchar("updUserId", 50)
}