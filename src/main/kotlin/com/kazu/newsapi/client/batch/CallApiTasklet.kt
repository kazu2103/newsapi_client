package com.kazu.newsapi.client.batch

import com.kazu.newsapi.client.service.RestService
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class CallApiTasklet: Tasklet {

    private val log: Logger = LoggerFactory.getLogger(this::class.java)

    @Autowired
    lateinit var restService: RestService

    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        val resultMap = restService.callEverythingApi()
        log.info(resultMap.get("message"))
        return RepeatStatus.CONTINUABLE
    }
}