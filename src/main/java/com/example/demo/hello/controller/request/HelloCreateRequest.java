package com.example.demo.hello.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class HelloCreateRequest {
    private String title;
    private String description;
    private boolean published;
}
