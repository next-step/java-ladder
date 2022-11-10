package ladder.model;

public class User {
    private static final int MAX_LENGTH = 5;
    private final String name;

    public User(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 값이 될 수 없습니다.");
        }

        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다. input: " + name);
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }
}
