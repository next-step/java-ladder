package nextstep.ladder.domain;

public class User {

    public static final int MAXIMUM_NAME_LENGTH = 5;
    private final String name;

    public static User of(String name) {
        return new User(name);
    }

    private User(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.length() > MAXIMUM_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하로 입력 해 주세요.");
        }
    }

    public String name() {
        return this.name;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}
