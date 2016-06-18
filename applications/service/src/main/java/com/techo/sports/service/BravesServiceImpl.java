package com.techo.sports.service;

import com.google.gson.Gson;
import com.techo.sports.common.Constants;
import com.techo.sports.domain.BravesResult;
import com.techo.sports.service.interfaces.BravesService;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.URLConnection;

/**
 * Created by TXT0627 on 6/17/2016.
 */
@Service
public class BravesServiceImpl implements BravesService {
    private URLConnection conn;
    private Gson gson = new Gson();

    @Override
    public String didTheBravesWin() throws IOException, Exception {
        BravesResult bravesResult = new BravesResult();
        Document doc = Jsoup.connect(Constants.BRAVES_SCHEDULE).get();
        Elements scores = doc.getElementsByClass("score");
        if (scores.size() > 0) {
            Element latestScore = scores.get(scores.size() - 1);
            Element game = latestScore.parent();
            bravesResult.setLink(Constants.ESPN_GO_PREFIX + game.getElementsByAttribute("href").get(0).attr("href"));
            Elements aTags = latestScore.getElementsByTag("a");

            //GET SCORE
            if (aTags.size() == 1 && null != aTags.get(0).childNodes() && aTags.get(0).childNodes().size() == 1) {
                bravesResult.setScore(aTags.get(0).childNode(0).toString());
            } else {
                throw new Exception("UH OH DIDN'T ACCOUNT FOR THIS");
            }

            //WIN, LOSS, or CURRENT
            Elements win = game.getElementsByClass("win");
            Elements loss = game.getElementsByClass("win");
            if(null != win && win.size() > 0){
                bravesResult.setWinLossOrOngoing("YES");
                bravesResult.setCssClass("win");
            } else if(null != loss && loss.size() > 0){
                bravesResult.setWinLossOrOngoing("NO");
                bravesResult.setCssClass("loss");
            } else {
                bravesResult.setWinLossOrOngoing("In Progress");
                bravesResult.setCssClass("ongoing");
            }
        } else {
            throw new Exception("No games recorded");
        }


        return gson.toJson(bravesResult);
    }
}
