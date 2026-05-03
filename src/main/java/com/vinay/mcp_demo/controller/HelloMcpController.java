package com.vinay.mcp_demo.controller;

import com.vinay.mcp_demo.dto.MCPDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@RestController
@RequestMapping("/api")
public class HelloMcpController {

     private final List<MCPDto> namesList;

    private final AtomicReference<BigInteger> counter =
            new AtomicReference<>(BigInteger.ZERO);

     public HelloMcpController() {
          namesList = new ArrayList<>();
     }

    @GetMapping("/hello")
    public String hello() {
        BigInteger newValue = counter.updateAndGet(current -> current.add(BigInteger.ONE));
        namesList.add(MCPDto.builder().name("ABC").age(newValue.toString()).build());
        System.out.println(" INSIDE METHOD Hello " + newValue);
        return "Hello MCP " + newValue;
    }
}
