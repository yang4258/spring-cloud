zuul: 网关 （熔断-fallback）
eureka1,eureka12: 注册中心
config: 配置中心 需要从配置中心读取配置文件的服务，配置文件名：bootstrap.properties（优先级高于application.properties）

monitor: 熔断聚合监控
    监控多个服务熔断器情况 5001为monitor端口 浏览器输入 http://localhost:5001/hystrix  填入 http://localhost:5001/turbine.stream
admin: 微服务监控 
    监控页面 locahost:port
    被监控服务引入 spring-boot-starter-actuator，spring-boot-admin-starter-client
    配置文件写入   ## actuator 暴露所有端点 management.endpoints.web.exposure.include=*
zipkin: 服务链路追踪服务端 springboot1.5(2.x兼容有问题)   浏览器输入 http://localhost:9411/zipkin/

order-service: 服务提供方 （配置了 配置中心 获取配置文件，需要先启动注册中心，配置中心，否则启动失败）
user-service: 服务提供方
user-view: 服务消费方 （fegin, ribbon, Hystrix, actuator, admin-client, zipkin-client）
order-view: 服务消费方