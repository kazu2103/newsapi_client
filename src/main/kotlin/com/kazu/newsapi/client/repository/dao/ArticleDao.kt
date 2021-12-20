package com.kazu.newsapi.client.repository.dao

import com.kazu.newsapi.client.repository.table.ArticleTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID


class ArticleDao(id: EntityID<Int>): IntEntity(id) {
    companion object: IntEntityClass<ArticleDao>(ArticleTable)

    var sourceId by ArticleTable.sourceId
    var sourceName by ArticleTable.sourceName
    var author by ArticleTable.author
    var title by ArticleTable.title
    var description by ArticleTable.description
    var url by ArticleTable.url
    var urlToImage by ArticleTable.urlToImage
    var publishAt by ArticleTable.publishAt
    var content by ArticleTable.content
    var creDate by ArticleTable.creDate
    var creUserId by ArticleTable.creUserId
    var updDate by ArticleTable.updDate
    var updUserId by ArticleTable.updUserId
}