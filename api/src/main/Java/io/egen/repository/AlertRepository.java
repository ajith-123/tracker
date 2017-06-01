package io.egen.repository;

import io.egen.entity.Alert;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Ajith on 5/30/2017.
 */

public interface AlertRepository {

    Alert insertAlert(Alert alert);

    List<Alert> insertAlerts(List<Alert> alerts);

}
