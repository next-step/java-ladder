package nextstep.ladder;

import java.util.Optional;

public class User {
    private static final int MAX_NAME_LENTH = 5;

    private final String name;

    public User(String name) {
        valdateName(name);
        this.name = name;
    }

    public void valdateName(String name) {
        Optional.ofNullable(name)
                .filter(n -> n.length() <= MAX_NAME_LENTH)
                .orElseThrow(() -> new IllegalArgumentException("이름은 최대 5자리만 입력 가능합니다."));

    }

}
