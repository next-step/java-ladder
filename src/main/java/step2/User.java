package step2;

public class User {
    public static final int USER_NAME_MAX_LENGTH = 5;

    private final String name;

    public User(String name) {
        if (name.length() > USER_NAME_MAX_LENGTH) {
            throw new IllegalArgumentException("사람의 이름은 5글자를 넘을 수 없습니다.");
        }

        this.name = name;
    }

    public String toOutputString() {
        return name;
    }
}
