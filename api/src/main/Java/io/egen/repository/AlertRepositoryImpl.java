package io.egen.repository;

import io.egen.entity.Alert;
import io.egen.entity.Vehicle;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ajith on 5/30/2017.
 */
@Repository
public class AlertRepositoryImpl implements AlertRepository {

    @PersistenceContext
    private EntityManager em;

    @Override

    public Alert insertAlert(Alert alert) {
        em.persist(alert);
        return alert;
    }

    @Override
    @Transactional
    public List<Alert> insertAlerts(List<Alert> alerts) {
        List<Alert> alertList = new ArrayList<Alert>();
        for (Alert alert : alerts) {
            alertList.add(insertAlert(alert));
        }
        return alertList;
    }
}
