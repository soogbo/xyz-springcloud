# springcloud learning demo by soogbo

# springcloud netflix consul eureka ribbon feign config hystrix

# xyz-springcloud作为父模块，分模块实现各服务demo

# 各服务路径端口：
eureka-server：http://127.0.0.1:1001/
eureka-client：http://127.0.0.1:2001/
eureka-consumer：http://127.0.0.1:2101/
eureka-consumer-ribbon：http://127.0.0.1:2201/
eureka-consumer-feign：http://127.0.0.1:2301/
config-server-git：http://127.0.0.1:1201/
config-client：http://127.0.0.1:2001/
eureka-consumer-ribbon-hystrix：http://127.0.0.1:2401/
eureka-consumer-ribbon-hystrix：http://127.0.0.1:2401/hystrix.stream
hystrix-dashboard：http://127.0.0.1:1301/hystrix	
turbine：http://127.0.0.1:8989/turbine.stream
turbine-amqp：http://127.0.0.1:8989/turbine.stream need mqserver


# config-client-demo 连接测试：启动config-server-git
http://127.0.0.1:1201/config-client/dev/master

# config-client客户端连接服务端获取配置中心配置：启动config-server-git config-client
http://127.0.0.1:1202/info 测试无效
两种方式获取配置文件中对应key的值：
http://127.0.0.1:1202/config-client/gitvalue
http://127.0.0.1:1202/config-client/gitenv
