package io.egen.service;

import io.egen.entity.Alert;
import io.egen.repository.AlertRepository;
import io.egen.repository.ReadingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ajith on 5/30/2017.
 */
@Service
public class AlertServiceImpl implements AlertService {
    @Autowired
    private AlertRepository alertRepository;

    @Override
    public Alert insertAlert(Alert alert) throws Exception {
        Alert al = new Alert();
        al = alertRepository.insertAlert(alert);
        if (al == null) {
            throw new Exception("Error in storing data to database");
        }
        return al;
    }

    @Override
    public List<Alert> insertAlertList(List<Alert> alerts) throws Exception {
        List<Alert> alerts1 = alertRepository.insertAlerts(alerts);
        return alerts1;
    }
}
