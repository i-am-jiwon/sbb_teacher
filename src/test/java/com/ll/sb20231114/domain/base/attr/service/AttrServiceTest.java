package com.ll.sb20231114.domain.base.attr.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AttrServiceTest {
    @Autowired
    private AttrService attrService;

    @DisplayName("변수를 저장할 수 있다.")
    @Test
    void t1() {
        attrService.set("age", 22);

        long age = attrService.getAsLong("age", 0);

        assertThat(age).isEqualTo(22);
    }
}
