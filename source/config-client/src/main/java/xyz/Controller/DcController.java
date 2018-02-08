package xyz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope
@RestController
public class DcController {

	// 方法1：@Value获取
	@Value("${info.profile}")
	private String gitvalue;

	// 方法2：Environment对象获取
	// org.springframework.core.env.Environment包，不是org.springframework.cloud.config.environment.Environment;
	@Autowired
	private Environment gitenv;

	@GetMapping("/config-client/gitvalue")
	public String dc1() {
		System.out.println("get config-client/gitvalue value:" + gitvalue);
		return gitvalue;
	}

	@GetMapping("/config-client/gitenv")
	public String dc2() {
		String property = gitenv.getProperty("info.profile");
		System.out.println("get config-client/gitenv value:" + property);
		return property;
	}

}
