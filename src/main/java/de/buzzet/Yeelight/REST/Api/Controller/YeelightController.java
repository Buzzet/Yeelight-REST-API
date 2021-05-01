package de.buzzet.Yeelight.REST.Api.Controller;

import de.buzzet.Yeelight.REST.Api.Services.YeelightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class YeelightController {

    @Autowired
    YeelightService yeelightService;

    @CrossOrigin
    @GetMapping("/toggle")
    public void toogleLight(@RequestParam(value = "ip") String ip, @RequestParam(value = "toggle") String toggle){
        yeelightService.set(ip, 55443);
        yeelightService.setPower(toggle, 30);
    }

}

