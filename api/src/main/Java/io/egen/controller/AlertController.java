package io.egen.controller;

//import io.egen.service.ReadingService;

import io.egen.service.AlertService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Ajith on 5/29/2017.
 */
@Component
public class AlertController {
    @Autowired
    private AlertService alertService;


}
