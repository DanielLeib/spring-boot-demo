package com.example.demo.hello.mapper;

import com.example.demo.hello.controller.canonicalmodel.Hello;
import com.example.demo.hello.controller.request.HelloCreateRequest;
import com.example.demo.hello.controller.response.HelloResponse;
import com.example.demo.hello.datamodel.HelloJpaEntity;
import lombok.experimental.UtilityClass;

@UtilityClass
public class HelloMapper {

    public HelloJpaEntity canonicalToJpaEntity(Hello model) {
        return HelloJpaEntity.builder()
                .id(model.getId())
                .description(model.getDescription())
                .title(model.getTitle())
                .published(model.isPublished())
                .build();
    }

    public Hello requestToCanonical(HelloCreateRequest request) {
        return Hello.builder()
                .description(request.getDescription())
                .title(request.getTitle())
                .published(request.isPublished())
                .build();
    }

    public Hello jpaEntityToCanonical(HelloJpaEntity entity) {
        return Hello.builder()
                .id(entity.getId())
                .published(entity.isPublished())
                .title(entity.getTitle())
                .description(entity.getDescription())
                .build();
    }

    public HelloResponse canonicalToResponse(Hello model) {
        return HelloResponse.builder()
                .id(model.getId())
                .description(model.getDescription())
                .title(model.getTitle())
                .published(model.isPublished())
                .build();
    }
}
