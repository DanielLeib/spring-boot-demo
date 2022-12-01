package com.example.demo.hello.repository;

import com.example.demo.hello.datamodel.HelloJpaEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HelloRepository extends JpaRepository<HelloJpaEntity, Long> {

    List<HelloJpaEntity> findByPublished(boolean published);

    List<HelloJpaEntity> findByTitleContaining(String title);
}
