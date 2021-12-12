package nextstep.ladder.model;

import nextstep.ladder.utils.StringUtils;

import java.util.Optional;

public class Name {

    private static final int NAME_MAX_LENGTH = 5;
    private static final String EXCEPTION_NAME_MAX_LENGTH_OVER = "사람 이름은 5글자를 초과할 수 없습니다.";

    private final String name;

    public Name(String name) {
        this.name = validationNameLength(StringUtils.isNullOrEmpty(name));
    }

    private String validationNameLength(String name) {
        return Optional.ofNullable(name)
                .filter(n -> n.length() <= NAME_MAX_LENGTH)
                .orElseThrow(() -> new IllegalArgumentException(EXCEPTION_NAME_MAX_LENGTH_OVER));
    }

    public String getName() {
        return name;
    }
}
