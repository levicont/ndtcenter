package com.lvg.tests.models.com.lvg.tests.mongo

import com.lvg.ndtcenter.config.AppConfig
import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import static org.junit.Assert.assertNotNull

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = [AppConfig.class])
abstract class GCommonMongoTest extends GroovyTestCase{
    protected static MongoCollection testCollection

    protected static String dataBaseName = 'test'
    protected static MongoDatabase database

    @Autowired
    MongoClient mongoClient

    @Before
    void testConnection(){
        init('ndtcenter')

    }

    protected void init(String collectionName){
        database = mongoClient.getDatabase(dataBaseName)
        testCollection = database.getCollection(collectionName)
        testCollection.drop()

    }



}
