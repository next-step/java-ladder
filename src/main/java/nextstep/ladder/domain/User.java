package nextstep.ladder.domain;

public class User {
    public static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public User(String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 미만이어야 합니다.");
        }
    }

    public boolean isEqualName(String name) {
        return this.name.equals(name);
    }

    public String getName() {
        return name;
    }
}
