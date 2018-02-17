package xyz;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@EnableHystrixDashboard // 启用HystrixDashboard功能
@SpringCloudApplication
public class Application {

	public static void main(String[] args) {
		// new SpringApplicationBuilder(Application.class).web(true).run(args);
		SpringApplication.run(Application.class, args);
	}
}
