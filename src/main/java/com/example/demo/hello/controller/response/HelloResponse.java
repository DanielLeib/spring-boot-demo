package com.example.demo.hello.controller.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class HelloResponse {
    private long id;
    private String title;
    private String description;
    private boolean published;
}
