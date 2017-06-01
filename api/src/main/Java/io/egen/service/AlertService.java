package io.egen.service;

import io.egen.entity.Alert;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Ajith on 5/30/2017.
 */
@Service
public interface AlertService {

    public Alert insertAlert(Alert alert) throws Exception;

    public List<Alert> insertAlertList(List<Alert> alerts) throws Exception;


}
