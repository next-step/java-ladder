package nextstep.ladder.domain;

public class User {
    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public User(String name) {
        if (name == null || name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("참여자의 이름은 최대 5글자입니다");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
