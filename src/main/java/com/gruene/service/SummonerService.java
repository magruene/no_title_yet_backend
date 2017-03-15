package com.gruene.service;

import com.gruene.leagueapi.LeagueApiWrapper;
import net.rithms.riot.api.RiotApiException;
import net.rithms.riot.constant.Region;
import net.rithms.riot.dto.Summoner.Summoner;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Controller
@Path("summoner")
public class SummonerService {

    private final LeagueApiWrapper riotApi;

    @Inject
    public SummonerService(LeagueApiWrapper leagueApiWrapper) {
        Assert.notNull(leagueApiWrapper, "API cannot be null.");
        this.riotApi = leagueApiWrapper;
    }

    @GET
    @Path("by-name/{name}")
    @Produces(value = "application/json")
    public Response byName(@PathParam("name") String name) {
        try {
            Summoner summonerByName = riotApi.getRiotApi().getSummonerByName(Region.EUW, name);
            System.out.print(summonerByName);
            return Response.ok(summonerByName).build();
        } catch (RiotApiException e) {
            System.out.print(e.getMessage());
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
}
