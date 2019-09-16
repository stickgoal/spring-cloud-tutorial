package me.maiz.trainning.rpc.server;

public interface RatingService {
    /**
     * 给定一个电影名称，返回评分
     * @param movieName
     * @return
     */
    int  rate(String movieName);

}
