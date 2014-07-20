package com.gotsuliak.sinteztask.blackjack.ws;

import com.gotsuliak.sinteztask.blackjack.core.logic.BlackjackGame;
import com.gotsuliak.sinteztask.blackjack.core.logic.GameState;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/game")
public class GameService {

    @EJB
    private BlackjackGame game;

    @GET
    @Path("/makeBet/{sum}")
    @Produces({MediaType.TEXT_HTML})
    public String makeBet(@PathParam("sum") Long sum) {
        GameState gameState = game.makeBet(sum);

        return "A new bet was made " + gameState.getPlayer().getCards().size();
    }

    @GET
    @Path("/hit")
    @Produces({MediaType.TEXT_HTML})
    public String hit() {
        GameState gameState = game.hit();
        return "Hit was made " + gameState.getPlayer().getCards().size();
    }

    public void stand() {
    }

}
