package com.techo.sports.service;

import com.techo.sports.common.Constants;
import com.techo.sports.service.interfaces.HawksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by TXT0627 on 6/17/2016.
 */
@Service
public class HawksServiceImpl implements HawksService {
    private String hawksResultJSON = "";
    private GenericScraperServiceImpl genericScraperServiceImpl;

    @Autowired
    public HawksServiceImpl(final GenericScraperServiceImpl genericScraperServiceImpl) {
        this.genericScraperServiceImpl = genericScraperServiceImpl;
    }

    @Scheduled(cron = "*/30 * * * * *")
    private void scrapeHawksESPN() throws Exception {
        System.out.println("**************************************");
        System.out.println("SCHEDULED HAWKS SCRAPE HAS BEGUN AT " + new Date());
        System.out.println("**************************************");

        hawksResultJSON = genericScraperServiceImpl.scrapeESPN(Constants.HAWKS_SCHEDULE);

        System.out.println("**************************************");
        System.out.println("SCHEDULED HAWKS SCRAPE HAS FINISHED AT " + new Date());
        System.out.println("RESULTING JSON: " + hawksResultJSON);
        System.out.println("**************************************");
    }

    @Override
    public String didTheHawksWin() {
        return hawksResultJSON;
    }
}
