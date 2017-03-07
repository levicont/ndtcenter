package com.lvg.ndtcenter.repositories

import com.lvg.ndtcenter.models.Direction
import com.lvg.ndtcenter.models.Student
import org.springframework.data.mongodb.repository.MongoRepository


interface DirectionRepository extends MongoRepository<Direction, BigInteger>{
    List<Direction> findByStudent(Student student)
}
