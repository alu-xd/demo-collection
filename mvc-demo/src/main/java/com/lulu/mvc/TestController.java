package com.lulu.mvc;

import com.lulu.mvc.resolver.MagicBox;
import com.lulu.mvc.resolver.MagicBoxVo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping(path = "/demo")
    public String handle(@RequestParam("name") String name, @MagicBox MagicBoxVo magicBoxVo, @RequestBody Object body) {
        System.out.println("name called: " + name);

        System.out.println("random=" + magicBoxVo.getRandomNum() + "  " + "gift=" + magicBoxVo.getGift());

        System.out.println("boyd=" + body);
        return "hello";
    }
}
