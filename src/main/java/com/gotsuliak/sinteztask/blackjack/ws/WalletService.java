package com.gotsuliak.sinteztask.blackjack.ws;

import com.gotsuliak.sinteztask.blackjack.manager.GameManager;
import com.gotsuliak.sinteztask.blackjack.ws.container.request.DepositRequest;
import com.gotsuliak.sinteztask.blackjack.ws.container.response.Response;
import com.gotsuliak.sinteztask.blackjack.ws.container.response.TransactionsResponse;
import com.gotsuliak.sinteztask.blackjack.ws.container.response.WalletResponse;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/wallet")
public class WalletService {

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

    @POST
    @Path("/deposit")
    @Produces({MediaType.APPLICATION_XML})
    public WalletResponse deposit(DepositRequest request) {
        manager.putMoney(request.getWalletId(), request.getSum());
        return new WalletResponse();
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
