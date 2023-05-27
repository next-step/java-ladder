package ladder.domain;

import java.util.Optional;

public class Player {

    private static final int MAX_NAME_LENGTH = 5;

    private String name;

    public Player(String name) {
        this.name = validateName(name);
    }

    private String validateName(String name) {
        return Optional.ofNullable(name)
                .filter(s -> s.length() <= MAX_NAME_LENGTH)
                .orElseThrow(() -> new IllegalArgumentException("입력한 이름의 글자 수가 너무 깁니다. (최대 길이 : " + MAX_NAME_LENGTH + "자)"));
    }

    public String getName() {
        return name;
    }
}
