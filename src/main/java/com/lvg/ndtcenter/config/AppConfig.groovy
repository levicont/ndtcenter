package com.lvg.ndtcenter.config

import com.mongodb.MongoClient
import com.mongodb.MongoClientURI
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories
import org.springframework.web.servlet.config.annotation.EnableWebMvc

@Configuration
@EnableMongoRepositories('com.lvg.ndtcenter.repositories')
@ComponentScan(['com.lvg.ndtcenter.listeners'])
class AppConfig {

    @Bean
    MongoClient mongoClient(){
        MongoClient mongoClient = new MongoClient(new MongoClientURI('mongodb://localhost'))
        return mongoClient
    }

    @Bean
    MongoTemplate mongoTemplate(){
        return new MongoTemplate(mongoClient(), "test")
    }


}
