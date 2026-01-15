package nextstep.ladder.domain;

public class Name {
    private int MAX_LENGTH = 5;
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("이름은 필수입니다");
        }

        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 %d자 이하여야 합니다".formatted(MAX_LENGTH));
        }
    }

    public String getValue() {
        return name;
    }
}
