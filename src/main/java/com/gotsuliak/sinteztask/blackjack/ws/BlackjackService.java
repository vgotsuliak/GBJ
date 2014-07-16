package com.gotsuliak.sinteztask.blackjack.ws;

import com.gotsuliak.sinteztask.blackjack.ws.container.Response;
import com.gotsuliak.sinteztask.blackjack.ws.container.TransactionsResponse;
import com.gotsuliak.sinteztask.blackjack.ws.container.WalletResponse;
import com.gotsuliak.sinteztask.blackjack.manager.GameManager;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/blackjack")
public class BlackjackService {

    @EJB
    private GameManager manager;

    @GET
    @Path("/start")
    @Produces({MediaType.APPLICATION_XML})
    public Response start() {
        WalletResponse response = new WalletResponse();
        response.setStatus(0);
        response.setWalletId(manager.startNewGame());
        return response;
    }

    @GET
    @Path("/deposit/{sum}")
    @Produces("text/plain")
    public String deposit(@PathParam("sum") Integer sum) {
        manager.putMoney(123, sum);
        return "deposit successfull + " + sum;
    }

    @GET
    @Path("/transactions/{wallet}")
    @Produces({MediaType.APPLICATION_XML})
    public TransactionsResponse getTransactions(@PathParam("wallet") Integer wallet) {
        TransactionsResponse response = new TransactionsResponse();
        response.setTransactions(manager.getTransactions(wallet));
        response.setStatus(0);
        return response;
    }

}
