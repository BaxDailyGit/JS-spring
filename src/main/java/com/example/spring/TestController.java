package com.example.spring;

import org.springframework.web.bind.annotation.*;

@RestController
public class TestController {

    @GetMapping("api/test/name")
    public String name() {
        String name = "bax";
        return name;
    }

    @GetMapping("api/test")
    public String query(@RequestParam String name) { //쿼리 파라미터
        return ("안녕하세요 " + name + "입니다.");
    }


    @GetMapping("api/test/{name}")
    public String path(@PathVariable String name) { //경로
        return ("안녕하세요 " + name + "입니다.");
    }


    @PostMapping("/api/post")
    public String requestTest(@RequestBody String name) {
        System.out.println("name = " + name);
        return name;
    }
}
