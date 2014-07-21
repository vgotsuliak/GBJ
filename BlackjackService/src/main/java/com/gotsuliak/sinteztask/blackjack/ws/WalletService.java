package com.gotsuliak.sinteztask.blackjack.ws;

import com.gotsuliak.sinteztask.blackjack.core.entity.Wallet;
import com.gotsuliak.sinteztask.blackjack.core.logic.WalletManager;
import com.gotsuliak.sinteztask.blackjack.ws.container.response.Response;
import com.gotsuliak.sinteztask.blackjack.ws.container.response.TransactionsResponse;
import com.gotsuliak.sinteztask.blackjack.ws.container.response.WalletResponse;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/wallet")
public class WalletService {

    @EJB
    private WalletManager manager;

    @GET
    @Path("/new")
    @Produces({MediaType.APPLICATION_XML})
    public Response newWallet() {
        WalletResponse response = new WalletResponse();
        response.setStatus(0);
        response.setWalletId(manager.newWallet().getId());
        return response;
    }

    @GET
    @Path("/deposit/{walletId}/{sum}")
    @Produces({MediaType.APPLICATION_XML})
    public WalletResponse deposit(@PathParam("walletId") int walletId, @PathParam("sum") long sum) {
        Wallet wallet = manager.putMoney(walletId, sum);
        WalletResponse response = new WalletResponse();
        response.setWalletId(wallet.getId());
        response.setSum(wallet.getSum());
        return response;
    }

    @GET
    @Path("/wallet/{walletId}")
    @Produces({MediaType.APPLICATION_XML})
    public WalletResponse getWallet(@PathParam("walletId") int walletId) {
        Wallet wallet = manager.getWallet(walletId);
        WalletResponse response = new WalletResponse();
        response.setWalletId(wallet.getId());
        response.setSum(wallet.getSum());
        return response;
    }

    @GET
    @Path("/transactions/{wallet}")
    @Produces({MediaType.APPLICATION_XML})
    public TransactionsResponse getTransactions(@PathParam("wallet") Integer wallet) {
        TransactionsResponse response = new TransactionsResponse();
        manager.getTransactions(wallet);
        response.setTransactions(null);
        response.setStatus(0);
        return response;
    }

}
