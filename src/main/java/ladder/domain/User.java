package ladder.domain;

public class User {

    private final String name;

    public User(String name) {
        checkNameLength(name);

        this.name = name;
    }

    public static void checkNameLength(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("사람의 이름은 최대 5글자까지만 입력가능하다.");
        }
    }

}
