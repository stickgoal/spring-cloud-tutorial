package me.maiz.trainning.rpc.client;

import me.maiz.trainning.rpc.server.RatingService;

import java.util.Scanner;

public class MyMovieSite {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入您喜欢的电影，我们将为你评分");
        String movieName = sc.next();
        RatingService ratingService = new RatingServiceProxyService();
        int result =ratingService.rate(movieName);
        System.out.println("您输入的电影《"+movieName+"》评分为"+result);
        sc.close();
    }
}
