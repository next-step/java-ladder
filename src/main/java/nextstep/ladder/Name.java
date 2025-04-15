package nextstep.ladder;

public class Name {
    private static final int MAX_LENGTH = 5;
    private static final String BLANK = " ";
    private final String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

    public String toStringWithBlank() {
        return name + BLANK.repeat(MAX_LENGTH + 1 - name.length());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Name)) return false;
        Name name = (Name) o;
        return this.name.equals(name.name);
    }

    private void validate(String name) {
        validateEmpty(name);
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하이어야 합니다.");
        }
    }

    private void validateEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 null 또는 빈 문자열일 수 없습니다.");
        }
    }
}
