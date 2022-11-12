package nextstep.ladder.domain;

public class User {

    private static final int MAX_LENGTH = 5;
    private final String name;

    public User(String name) {
        validateIsBlank(name);
        validateMaxlength(name);

        this.name = name;
    }

    private void validateIsBlank(String name) {
        if(name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 빈 값이 될 수 없습니다.");
        }
    }

    private void validateMaxlength(String name) {
        if(name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자를 초과할 수 없습니다.");
        }
    }

    public String getName() {
        return name;
    }
}
