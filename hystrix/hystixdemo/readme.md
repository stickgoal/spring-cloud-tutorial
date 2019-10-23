# hystrix入门案例

## 目标：
- 测试hystrix的fallback功能
- 测试hystrix的circuitBreaker的开启效果
- 测试feign的hystrix集成效果
- 测试hystrix的监控


## 依赖说明：
1. spring-cloud-starter-netflix-hystrix 提供hystrix的功能
2. spring-boot-starter-actuator    提供信息暴露
3. spring-cloud-starter-openfeign 集成feign客户端
4. spring-cloud-starter-netflix-hystrix-dashboard 提供hystrix的监控

## 配置说明
暴露所有的监控端点，路径为 /actuator/XXX  配置详见[文档](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-features.html#production-ready-endpoints)
management.endpoints.web.exposure.include=*

显示详情，这里是为了显示hystrix的熔断器状态
management.endpoint.health.show-details = always

## 代码说明
- 此处为调用端（客户端）代码，消费端（服务端）代码为review1
- 使用RestTemplate调用review服务，并设置fallback方法，如果底层服务故障，则调用fallback方法
- 频繁调用失败（默认为10s内20次），看到circuitbreaker状态为打开，不再每次都调用底层服务
- 通过在@HystrixCommand配置circuitBreaker.requestVolumeThreshold属性可以自定义circuitBreaker打开的阈值 其他配置参考[文章](https://blog.csdn.net/tongtong_use/article/details/78611225)
- feign客户端默认启用了hystrix，通过@FeignClient的fallback属性提供回退的类，通过fallbackFactory属性提供回退类及回退的错误信息
- hystrix的监控只需要添加依赖，在Application上添加@EnableHystrixDashboard注解，访问/hystrix即可，注意要添加的路径是：http://localhost:9100/actuator/hystrix.stream

# 步骤