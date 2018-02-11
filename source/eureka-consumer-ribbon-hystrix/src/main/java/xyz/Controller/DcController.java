package xyz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class DcController {

    @Autowired
    private ConsumerService consumerService;

    @GetMapping("/consumer/ribbon/hystrix/dc")
    public String dc() {
        String result = consumerService.consumer();
        System.out.println("get message from client dc by ribbon hystrix:" + result);
        return result;
    }
    
    @Service
    class ConsumerService {
        
        @Autowired
        private RestTemplate restTemplate;
        
        // hystrix服务容错保护之服务降级
        // 指定服务降级方法
        @HystrixCommand(fallbackMethod="fallback")
        public String consumer() {
            String url = "http://eureka-client/dc";
            String result = restTemplate.getForObject(url, String.class);
            return result;
        }
        
        public String fallback() {
            return "fallback";
        }
        
    }
}
