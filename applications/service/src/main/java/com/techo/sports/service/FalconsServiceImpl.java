package com.techo.sports.service;

import com.techo.sports.common.Constants;
import com.techo.sports.service.interfaces.FalconsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by TXT0627 on 6/17/2016.
 */
@Service
public class FalconsServiceImpl implements FalconsService {
    private String falconsResultJSON = "";
    private GenericScraperServiceImpl genericScraperServiceImpl;

    @Autowired
    public FalconsServiceImpl(final GenericScraperServiceImpl genericScraperServiceImpl) {
        this.genericScraperServiceImpl = genericScraperServiceImpl;
    }

    @Scheduled(cron = "*/30 * * * * *")
    private void scrapeFalconsESPN() throws Exception {
        System.out.println("**************************************");
        System.out.println("SCHEDULED FALCONS SCRAPE HAS BEGUN AT " + new Date());
        System.out.println("**************************************");

        falconsResultJSON = genericScraperServiceImpl.scrapeESPN(Constants.FALCONS_SCHEDULE);

        System.out.println("**************************************");
        System.out.println("SCHEDULED FALCONS SCRAPE HAS FINISHED AT " + new Date());
        System.out.println("RESULTING JSON: " + falconsResultJSON);
        System.out.println("**************************************");
    }

    @Override
    public String didTheFalconsWin() {
        return falconsResultJSON;
    }
}
