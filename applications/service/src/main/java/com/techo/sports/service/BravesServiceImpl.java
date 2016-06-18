package com.techo.sports.service;

import com.techo.sports.common.Constants;
import com.techo.sports.service.interfaces.BravesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by TXT0627 on 6/17/2016.
 */
@Service
public class BravesServiceImpl implements BravesService {
    private String bravesResultJSON = "";
    private GenericScraperServiceImpl genericScraperServiceImpl;

    @Autowired
    public BravesServiceImpl(final GenericScraperServiceImpl genericScraperServiceImpl) {
        this.genericScraperServiceImpl = genericScraperServiceImpl;
    }

    @Scheduled(cron = "*/30 * * * * *")
    private void scrapeBravesESPN() throws Exception {
        System.out.println("**************************************");
        System.out.println("SCHEDULED BRAVES SCRAPE HAS BEGUN AT " + new Date());
        System.out.println("**************************************");

        bravesResultJSON = genericScraperServiceImpl.scrapeESPN(Constants.BRAVES_SCHEDULE);

                System.out.println("**************************************");
        System.out.println("SCHEDULED BRAVES SCRAPE HAS FINISHED AT " + new Date());
        System.out.println("RESULTING JSON: " + bravesResultJSON);
        System.out.println("**************************************");
    }

    @Override
    public String didTheBravesWin(){
        return bravesResultJSON;
    }
}
