package nextstep.step4.domain;

public class User {

    private static final int LENGTH_LIMIT = 5;
    private final String name;

    private User(String name) {
        checkNameLength(name);
        this.name = name;
    }

    private void checkNameLength(String name) {
        if(name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public static User of(String name) {
        return new User(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
