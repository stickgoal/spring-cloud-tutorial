package me.maiz.trainning.rpc.server;

public class RatingServiceImpl implements RatingService {


    @Override
    public int rate(String movieName) {
        if(movieName==null||movieName.length()==0||movieName.trim().length()==0){
            return -1;
        }
        return movieName.length()%3;
    }
}
