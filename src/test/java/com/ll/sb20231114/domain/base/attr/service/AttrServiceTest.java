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

    @DisplayName("변수의 값을 boolean 형태로 받을 수 있다.")
    @Test
    void t2() {
        attrService.set("married", true);

        boolean married = attrService.getAsBool("married", false);

        assertThat(married).isEqualTo(true);
    }

    @DisplayName("변수의 값은 덮어쓰기가 가능하다.")
    @Test
    void t3() {
        attrService.set("siteOwner", "홍길동");
        attrService.set("siteOwner", "임꺽정");

        String siteOwner = attrService.get("siteOwner", null);

        assertThat(siteOwner).isEqualTo("임꺽정");
    }
}
