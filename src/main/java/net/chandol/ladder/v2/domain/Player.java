package net.chandol.ladder.v2.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.function.Predicate;

public class Player {
    private static final int MAX_LENGTH = 5;
    private String name;

    public Player(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        Predicate<String> isNullOrEmpty = n -> null == n || n.length() == 0;
        Predicate<String> isExceedLength = n -> n.length() > MAX_LENGTH;

        if (isNullOrEmpty.test(name) || isExceedLength.test(name)) {
            throw new IllegalArgumentException("name길이를 확인해주세요.");
        }
    }

    public String getName() {
        return name;
    }

    public String getNameWithFixedLength() {
        return StringUtils.center(name, MAX_LENGTH);
    }
}
