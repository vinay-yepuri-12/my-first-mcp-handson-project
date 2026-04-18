package com.vinay.mcp_demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloMcpController {

    @GetMapping("/hello")
    public String hello() {
        return "Hello MCP";
    }
}
