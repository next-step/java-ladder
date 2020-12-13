package nextstep.step4.domain;

public class User {

    private static final int LENGTH_LIMIT = 5;

    private int index;
    private final String name;

    private User(int index, String name) {
        checkNameLength(name);
        this.index = index;
        this.name = name;
    }

    private void checkNameLength(String name) {
        if(name.length() > LENGTH_LIMIT) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
    }

    public static User of(int index, String name) {
        return new User(index, name);
    }

    @Override
    public String toString() {
        return name;
    }
}
