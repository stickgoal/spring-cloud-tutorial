package com.woniuxy.architectcourse.cloud.hystixdemo.client;

import com.woniuxy.architectcourse.cloud.hystixdemo.model.Review;
import com.woniuxy.architectcourse.cloud.hystixdemo.web.MovieController;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * FallbackFactory可以提供调用的错误信息
 */
@Component
public class ReviewClientFallBackFactory implements FallbackFactory<ReviewClient> {
    public static final Logger logger = LoggerFactory.getLogger(ReviewClientFallBackFactory.class);


    @Override
    public ReviewClient create(Throwable throwable) {
        return new ReviewClient() {
            @Override
            public Review findReviewById(int reviewId) {
                Review review = new Review(-1, -1, -1, "暂无内容", new Date());
                logger.warn("访问review服务出现故障，执行降级服务，错误原因：", throwable);
                return review;
            }
        };
    }
}
