package io.egen.controller;

import io.egen.entity.Reading;
import io.egen.service.ReadingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Ajith on 5/29/2017.
 */
@RestController
@RequestMapping("/readings")
public class ReadingController {
    @Autowired
    private ReadingService readingService;

    @RequestMapping(method = RequestMethod.POST, value = "")
    public Reading insertReading(@RequestBody Reading reading) throws Exception {
        readingService.insertReading(reading);
        return reading;
    }

}
