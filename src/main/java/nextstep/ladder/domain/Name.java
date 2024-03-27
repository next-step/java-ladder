package nextstep.ladder.domain;

public class Name {

    private static final int MAX_NAME_LENGTH = 5;

    private final String name;

    public Name(final String name) {
        validateEmpty(name);
        validateNameLength(name);
        this.name = name;
    }

    private void validateNameLength(final String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름의 길이는 5자를 초과할 수 없습니다.");
        }
    }

    private void validateEmpty(final String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름의 길이는 5자를 초과할 수 없습니다.");
        }
    }
}
