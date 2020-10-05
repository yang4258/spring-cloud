zuul: 网关
eureka1,eureka12: 注册中心
config: 配置中心
monitor: 熔断监控（监控多个服务熔断器情况 5001为monitor端口 浏览器输入 http://localhost:5001/hystrix  填入 http://localhost:5001/turbine.stream）
admin: 微服务监控
sleuth: 服务链路追踪 zipkin
order-service: 服务提供方 （配置了 配置中心 获取配置文件，需要先启动注册中心，配置中心，否则启动失败）
user-service: 服务提供方
user-view: 服务消费方 （fegin, ribbon, Hystrix, actuator,admin-client）
order-view: 服务消费方