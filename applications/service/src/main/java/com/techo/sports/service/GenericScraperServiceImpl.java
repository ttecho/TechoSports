package com.techo.sports.service;

import com.google.gson.Gson;
import com.techo.sports.common.Constants;
import com.techo.sports.domain.GenericResult;
import com.techo.sports.service.interfaces.GenericScraperService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

/**
 * Created by TXT0627 on 6/18/2016.
 */
@Service
public class GenericScraperServiceImpl implements GenericScraperService {
    @Override
    public String scrapeESPN(String url) throws Exception{
        Gson gson = new Gson();
        GenericResult genericResult = new GenericResult();
        Document doc = Jsoup.connect(url).get();
        Elements scores = doc.getElementsByClass("score");
        if (scores.size() > 0) {
            Element latestScore = scores.get(scores.size() - 1);
            Element game = latestScore.parent();
            genericResult.setLink(Constants.ESPN_GO_PREFIX + game.getElementsByAttribute("href").get(0).attr("href"));
            Elements aTags = latestScore.getElementsByTag("a");

            //GET SCORE
            if (aTags.size() == 1 && null != aTags.get(0).childNodes() && aTags.get(0).childNodes().size() == 1) {
                genericResult.setScore(aTags.get(0).childNode(0).toString());
            } else {
                genericResult.setError("More than one score....");
                genericResult.setCssClass("error");
                return gson.toJson(genericResult);
            }

            //WIN, LOSS, or CURRENT
            Elements win = game.getElementsByClass("win");
            Elements loss = game.getElementsByClass("loss");
            if(null != win && win.size() > 0){
                genericResult.setWinLossOrOngoing("YES");
                genericResult.setCssClass("win");
            } else if(null != loss && loss.size() > 0){
                genericResult.setWinLossOrOngoing("NO");
                genericResult.setCssClass("loss");
            } else {
                genericResult.setWinLossOrOngoing("Not Yet");
                genericResult.setCssClass("ongoing");
            }
        } else {
            genericResult.setError("Season has not started.");
            genericResult.setCssClass("error");
            genericResult.setLink(url);
            return gson.toJson(genericResult);
        }

        return gson.toJson(genericResult);
    }
}
