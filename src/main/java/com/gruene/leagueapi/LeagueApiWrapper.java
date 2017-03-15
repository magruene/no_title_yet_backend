package com.gruene.leagueapi;

import net.rithms.riot.api.RiotApi;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class LeagueApiWrapper {
    private final RiotApi riotApi;

    public LeagueApiWrapper(@Value("${league.apiKey}") String apiKey) {
        this.riotApi = new RiotApi(apiKey);
    }

    public RiotApi getRiotApi() {
        return riotApi;
    }
}
