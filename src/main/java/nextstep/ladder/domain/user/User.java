package nextstep.ladder.domain.user;

public class User {
    private final String name;

    public User(String name) {
        validate(name);
        this.name = name;
    }

    private static void validate(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("사람이름은 최대 5자 입니다.");
        }
    }
}
