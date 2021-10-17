package com.lulu.mvc;

import com.lulu.mvc.resolver.MagicBoxVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController2 {

    @PostMapping(path = "/demo2")
    public String handle(@RequestBody MagicBoxVo body) {

        System.out.println("random=" + body.getRandomNum() + "  " + "gift=" + body.getGift());
        System.out.println("unknownBox=" + body.getUnknownBox().getBox());
        return "hello";
    }
}
