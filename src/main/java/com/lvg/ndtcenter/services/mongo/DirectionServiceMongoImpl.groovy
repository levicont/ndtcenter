package com.lvg.ndtcenter.services.mongo

import com.lvg.ndtcenter.models.Direction
import com.lvg.ndtcenter.repositories.DirectionRepository
import com.lvg.ndtcenter.services.DirectionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service('directionService')
class DirectionServiceMongoImpl implements DirectionService{

    @Autowired
    DirectionRepository repository

    @Override
    List<Direction> findAll() {
        return repository.findAll()
    }

    @Override
    Direction save(Direction record) {
        return repository.save(record)
    }

    @Override
    void delete(Direction record) {
        repository.delete(record)
    }

    @Override
    Direction findByID(BigInteger id) {
        return repository.findOne(id)
    }
}
