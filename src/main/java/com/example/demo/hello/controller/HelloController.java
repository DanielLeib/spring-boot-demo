package com.example.demo.hello.controller;

import com.example.demo.hello.controller.request.HelloCreateRequest;
import com.example.demo.hello.controller.response.HelloResponse;
import com.example.demo.hello.mapper.HelloMapper;
import com.example.demo.hello.service.HelloService;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @GetMapping("/hellos")
    public ResponseEntity<List<HelloResponse>> getAllHellos()
    {
        var hellos = helloService.getAllHellos().stream()
                .map(h -> HelloMapper.canonicalToResponse(h))
                .collect(Collectors.toList());
        return new ResponseEntity<>(hellos, HttpStatus.OK);
    }

    @GetMapping("/hellos/{id}")
    public ResponseEntity<HelloResponse> getHelloById(
            @PathVariable("id") long id) {

            var hello = helloService.findById(id);
            if (hello.isPresent()) {
                return new ResponseEntity<>(HelloMapper.canonicalToResponse(hello.get()), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
    }

    @PostMapping("/hellos")
    public ResponseEntity<HelloResponse> createHello(@RequestBody HelloCreateRequest request) {
        try {
            var hello = helloService.create(HelloMapper.requestToCanonical(request));
            return new ResponseEntity<>(HelloMapper.canonicalToResponse(hello), HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}