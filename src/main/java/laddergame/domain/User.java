package laddergame.domain;

public class User {
    private final String name;

    public User(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }
        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 가능합니다.");
        }
    }
}
