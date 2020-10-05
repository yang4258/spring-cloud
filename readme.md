zuul: 网关
eureka1,eureka12: 注册中心
config: 配置中心
monitor: 熔断监控（监控多个服务）
sleuth: 服务链路追踪 zipkin
order-service: 服务提供方 （配置了 配置中心 获取配置文件）
user-service: 服务提供方
admin: 服务消费方 （fegin, ribbon, Hystrix, actuator）
order-view: 服务消费方