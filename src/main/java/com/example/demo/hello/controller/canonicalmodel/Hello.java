package com.example.demo.hello.controller.canonicalmodel;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Hello {
    private long id;
    private String title;
    private String description;
    private boolean published;
}
