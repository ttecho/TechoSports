package com.techo.sports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Tyler Techo on 6/13/2016.
 */
@RestController
@RequestMapping("/braves")
public class BravesController {

    @Autowired
    public BravesController() {

    }

    public ResponseEntity<String> didTheBravesWin() {
        return new ResponseEntity<>("TEST", null, HttpStatus.OK);
    }
}
