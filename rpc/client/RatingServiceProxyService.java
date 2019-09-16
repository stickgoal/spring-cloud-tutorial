package me.maiz.trainning.rpc.client;

import me.maiz.trainning.rpc.server.RatingService;

public class RatingServiceProxyService implements RatingService {

    RPCClient rpcClient = new RPCClient();
    @Override
    public int rate(String movieName) {

        Object result = rpcClient.execute("ratingService",Integer.class,movieName);

        return result!=null?(int)result:-1;
    }
}
