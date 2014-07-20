package com.gotsuliak.sinteztask.blackjack.ws;

import com.gotsuliak.sinteztask.blackjack.core.exception.BlackjackException;
import com.gotsuliak.sinteztask.blackjack.core.logic.GameState;
import com.gotsuliak.sinteztask.blackjack.core.logic.GameManager;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
import javax.xml.bind.JAXB;
import java.io.StringWriter;

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

    @Provider
    public static class ExceptionHandler implements ExceptionMapper<BlackjackException> {
        @Override
        public Response toResponse(BlackjackException e) {
            StringWriter writer = new StringWriter();
            JAXB.marshal(new com.gotsuliak.sinteztask.blackjack.ws.container.response.Response(e.getCode(), e.getMessage()), writer);
            return Response.status(200).entity(writer.toString()).build();
        }
    }

}
