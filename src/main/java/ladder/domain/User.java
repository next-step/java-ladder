package ladder.domain;

public class User {

    public static final int NAME_MAX_LENGTH = 5;
    private final String name;

    public User(String name) {
        if (NAME_MAX_LENGTH < name.length()) {
            throw new IllegalArgumentException("이름은 5글자를 초과할 수 없습니다.");
        }
        this.name = name;
    }

}
