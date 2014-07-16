package com.gotsuliak.sinteztask.blackjack.ws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Path("/blackjack")
public class BlackjackService {

    @GET
    @Path("/start")
    @Produces("text/plain")
    public String start() {
        return "someCoolWalletID";
    }

    @GET
    @Path("/deposit/{sum}")
    @Produces("text/plain")
    public String deposit(@PathParam("sum") Integer sum) {
        return "deposit successfull + " + sum;
    }

    @GET
    @Path("/transactions/{wallet}")
    @Produces("text/plain")
    public String getTransactions(@PathParam("wallet") Integer wallet) {
        return "transactions for wallet " + wallet;
    }

}
