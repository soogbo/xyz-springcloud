package xyz.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import xyz.Client.DcClient;

@RestController
public class DcController {

    @Autowired
    private DcClient dcClient;

    @GetMapping("/consumer/feign/dc")
    public String dc() {
        String result = dcClient.dc();
        System.out.println("get message from feign client dc by feign :" + result);
        return result;
    }

}
