package com.techo.sports.rest.controller;

import com.techo.sports.service.HawksServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by TXT0627 on 6/17/2016.
 */
@RestController
@RequestMapping("/hawks")
public class HawksController {
    private HawksServiceImpl hawksServiceImpl;

    @Autowired
    public HawksController(final HawksServiceImpl hawksServiceImpl) {
        this.hawksServiceImpl = hawksServiceImpl;
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public ResponseEntity<String> getHawksResult() {
        try {
            return new ResponseEntity<>(hawksServiceImpl.didTheHawksWin(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
