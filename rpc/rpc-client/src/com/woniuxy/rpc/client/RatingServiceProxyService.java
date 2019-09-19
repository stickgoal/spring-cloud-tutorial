package com.woniuxy.rpc.client;

import com.woniuxy.rpc.server.RatingService;

public class RatingServiceProxyService implements RatingService {

    RPCClient rpcClient = new RPCClient();

    @Override
    public int rate(String movieName) {

        Object result = rpcClient.execute("ratingService",Integer.class,movieName);

        return result!=null?(int)result:-1;
    }
}
