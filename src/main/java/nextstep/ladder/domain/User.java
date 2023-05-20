package nextstep.ladder.domain;

public class User {

    private static final int MAX_USER_NAME = 5;
    private static final String INVALID_USER_NAME = "사람의 이름은 최대 5자까지 가능합니다.";
    private final String name;

    public User(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAX_USER_NAME) {
            throw new IllegalArgumentException(INVALID_USER_NAME);
        }
    }


}
