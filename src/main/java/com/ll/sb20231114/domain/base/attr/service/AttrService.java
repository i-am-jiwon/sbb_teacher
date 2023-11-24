package com.ll.sb20231114.domain.base.attr.service;

import com.ll.sb20231114.domain.base.attr.entity.Attr;
import com.ll.sb20231114.domain.base.attr.repository.AttrRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class AttrService {
    private final AttrRepository attrRepository;

    @Transactional
    public void set(String name, boolean val) {
        set(name, String.valueOf(val));
    }

    @Transactional
    public void set(String name, long val) {
        set(name, String.valueOf(val));
    }

    @Transactional
    public void set(String name, String val) {
        Attr attr = Attr.builder()
                .name(name)
                .val(val)
                .build();

        attrRepository.save(attr);
    }

    public long getAsLong(String name, long defaultValue) {
        String val = get(name, null);

        if (val == null) {
            return defaultValue;
        }

        try {
            return Long.parseLong(val);
        } catch (NumberFormatException e) {
            return defaultValue;
        }
    }


    public boolean getAsBool(String name, boolean defaultValue) {
        String val = get(name, null);

        if (val == null) {
            return defaultValue;
        }

        return switch (val) {
            case "true" -> true;
            case "false" -> false;
            default -> defaultValue;
        };
    }

    private String get(String name, String defaultValue) {
        return attrRepository
                .findByName(name)
                .map(Attr::getVal)
                .orElse(defaultValue);
    }
}
