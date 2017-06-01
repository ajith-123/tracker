package io.egen.repository;

import io.egen.entity.Reading;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Created by Ajith on 5/30/2017.
 */
@Repository
public class ReadingRepostoryImpl implements ReadingRepository {
    @PersistenceContext
    private EntityManager em;

    @Override
    @Transactional
    public Reading insertReading(Reading reading) {
        //Reading reading_vehicle = new Reading();

        em.persist(reading);
        return reading;
    }
}
