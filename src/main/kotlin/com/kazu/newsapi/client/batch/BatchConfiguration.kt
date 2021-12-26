package com.kazu.newsapi.client.batch

import org.springframework.batch.core.Job
import org.springframework.batch.core.Step
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableBatchProcessing
class BatchConfiguration(val jobBuilderFactory: JobBuilderFactory, val stepBuilderFactory: StepBuilderFactory) {

    @Autowired
    lateinit var callApiTasklet: CallApiTasklet

    @Bean
    fun callApiJob(): Job? = jobBuilderFactory.get("callApiJob")?.start(callApiStep())?.build()

    @Bean
    fun callApiStep(): Step = stepBuilderFactory.get("callApiStep")?.tasklet(callApiTasklet)?.build()

}