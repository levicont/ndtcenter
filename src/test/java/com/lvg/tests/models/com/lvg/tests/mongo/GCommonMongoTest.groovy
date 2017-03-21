package com.lvg.tests.models.com.lvg.tests.mongo

import com.lvg.ndtcenter.config.AppConfig
import com.lvg.tests.models.com.lvg.tests.config.RObjects
import com.mongodb.MongoClient
import com.mongodb.client.MongoCollection
import com.mongodb.client.MongoDatabase
import org.junit.Before
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner

import static com.lvg.tests.models.com.lvg.tests.config.RObjects.DataBase.TEST_DB_NAME

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = [AppConfig.class])
abstract class GCommonMongoTest extends GroovyTestCase{
    protected static MongoCollection testCollection

    protected static RObjects.DataBase dataBaseName = TEST_DB_NAME
    protected static MongoDatabase database

    @Autowired
    MongoClient mongoClient

    @Before
    void testConnection(){
        init(RObjects.DataBase.STUDENT_COLLECTION_NAME)
    }

    protected void init(RObjects.DataBase collectionName){
        database = mongoClient.getDatabase(dataBaseName.value)
        testCollection = database.getCollection(collectionName.value)
        testCollection.drop()

    }



}
