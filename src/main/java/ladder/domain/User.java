package ladder.domain;

public class User {
    private final String name;

    public User(String name) {
        validate(name);
        this.name = name;
    }

    private static void validate(String name) {
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 5자 이하여야 합니다.");
        }
    }

    public String getName() {
        return this.name;
    }
}
