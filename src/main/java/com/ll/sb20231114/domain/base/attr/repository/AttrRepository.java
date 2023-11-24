package com.ll.sb20231114.domain.base.attr.repository;

import com.ll.sb20231114.domain.base.attr.entity.Attr;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttrRepository extends JpaRepository<Attr, Long> {
    Optional<Attr> findByName(String name);
}
