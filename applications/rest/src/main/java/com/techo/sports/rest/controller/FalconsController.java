package com.techo.sports.rest.controller;

import com.techo.sports.service.FalconsServiceImpl;
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
@RequestMapping("/falcons")
public class FalconsController {
    private FalconsServiceImpl falconsServiceImpl;

    @Autowired
    public FalconsController(final FalconsServiceImpl falconsServiceImpl) {
        this.falconsServiceImpl = falconsServiceImpl;
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public ResponseEntity<String> getFalconsResult() {
        try {
            return new ResponseEntity<>(falconsServiceImpl.didTheFalconsWin(), HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
