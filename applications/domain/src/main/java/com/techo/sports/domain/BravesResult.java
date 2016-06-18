package com.techo.sports.domain;

import lombok.Data;

/**
 * Created by TXT0627 on 6/17/2016.
 */
@Data
public class BravesResult {
    private String winLossOrOngoing;
    private String score;
    private String opposingTeam;
    private String link;
    private String cssClass;
}
