package com.gotsuliak.sinteztask.blackjack.ws;

import com.gotsuliak.sinteztask.blackjack.core.logic.BlackjackGame;
import com.gotsuliak.sinteztask.blackjack.core.logic.GameState;
import com.gotsuliak.sinteztask.blackjack.core.manager.GameManager;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/game")
public class GameService {

    @Inject
    private GameManager game;

    @GET
    @Path("/newGame")
    @Produces({MediaType.APPLICATION_XML})
    public GameState newGame() {
        return game.newGame();
    }

    @GET
    @Path("/makeBet/{sum}")
    @Produces({MediaType.APPLICATION_XML})
    public GameState makeBet(@PathParam("sum") Long sum) {
        return game.makeBet(sum);
    }

    @GET
    @Path("/hit")
    @Produces({MediaType.APPLICATION_XML})
    public GameState hit() {
        return game.hit();
    }

    @GET
    @Path("/stand")
    @Produces({MediaType.APPLICATION_XML})
    public GameState stand() {
        return game.stand();
    }

}
