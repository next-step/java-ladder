package domain;

public class Player {
    private final String name;

    public Player(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 필수입니다.");
        }

        if (name.length() > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자입니다.");
        }
    }

    public String getName() {
        return name;
    }
}
