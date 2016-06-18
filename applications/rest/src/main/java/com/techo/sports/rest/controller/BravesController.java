package com.techo.sports.rest.controller;

import com.techo.sports.service.BravesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * Created by TXT0627 on 6/17/2016.
 */
@RestController
@RequestMapping("/braves")
public class BravesController {
    private BravesServiceImpl bravesServiceImpl;

    @Autowired
    public BravesController(final BravesServiceImpl bravesServiceImpl) {
        this.bravesServiceImpl = bravesServiceImpl;
    }

    @RequestMapping(value = "/result", method = RequestMethod.GET)
    public ResponseEntity<String> getSkuDetails() {
        try {
            return new ResponseEntity<>(bravesServiceImpl.didTheBravesWin(), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<String>("Unexpected IO Failure!!!", null, HttpStatus.INTERNAL_SERVER_ERROR);
        }  catch (Exception e) {
            return new ResponseEntity<String>(e.getMessage(), null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
}
