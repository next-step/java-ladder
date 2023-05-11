package ladder.domain;

public class UserName {
    public static final int MAX_LENGTH_USER_NAME = 5;
    private final String name;

    public UserName(String name) {
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(String name) {
        if (name.length() > MAX_LENGTH_USER_NAME) {
            throw new IllegalArgumentException(String.format("이름은 %d글자를 초과 할 수 없습니다", MAX_LENGTH_USER_NAME));
        }
    }

    public String fetchName() {
        return name;
    }
}
