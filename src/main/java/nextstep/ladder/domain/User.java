package nextstep.ladder.domain;

public class User {
    private final String name;

    public User (String name) {
        validateName(name);
        this.name = name;
    }

    private void validateName(String name) {
        if (name.length() > 5 || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름은 1자 이상 5자 이하!");
        }
    }

    public String getName() {
        return name;
    }
}
