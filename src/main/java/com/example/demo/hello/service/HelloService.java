package com.example.demo.hello.service;

import com.example.demo.hello.controller.canonicalmodel.Hello;
import com.example.demo.hello.datamodel.HelloJpaEntity;
import com.example.demo.hello.mapper.HelloMapper;
import com.example.demo.hello.repository.HelloRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloService {
    @Autowired
    HelloRepository helloRepository;

    public List<Hello> getAllHellos() {
        return helloRepository.findAll().stream()
                .map(h -> HelloMapper.jpaEntityToCanonical(h)).collect(Collectors.toList());
    }

    public Optional<Hello> findById(Long id) {
        var response = helloRepository.findById(id);
        return Optional.of(HelloMapper.jpaEntityToCanonical(response.get()));
    }

    public Hello create(Hello model) {
        var savedEntity = helloRepository.save(HelloMapper.canonicalToJpaEntity(model));
        return HelloMapper.jpaEntityToCanonical(savedEntity);
    }
}
