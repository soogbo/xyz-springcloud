package xyz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class DcController {

//    @Autowired
//    private LoadBalancerClient loadBalancerClient;
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/consumer/ribbon/dc")
    public String dc() {
//        ServiceInstance serviceInstance = loadBalancerClient.choose("eureka-client");
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";
        
        //eureka-client,ribbon内置拦截器会替换eureka-client服务对应host
        String url = "http://eureka-client/dc";
        String result = restTemplate.getForObject(url, String.class);
        System.out.println("get message from client dc by ribbon :" + result);
        return result;
    }
}
