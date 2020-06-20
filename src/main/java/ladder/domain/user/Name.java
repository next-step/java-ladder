package ladder.domain.user;

public class Name {
    private static final int MAX_LENGTH = 5;

    private final String name;

    private Name(String name) {
        isNotNullOrEmpty(name);
        validateMaxLength(name);
        this.name = name;
    }

    public static Name of(String name) {
        return new Name(name);
    }

    private void isNotNullOrEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 null 이거나 빈 문자열일 수 없습니다.");
        }
    }

    private void validateMaxLength(String name) {
        if (name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자까지 입력할 수 있습니다.");
        }
    }

    @Override
    public String toString() {
        return String.format("%-6s", name);
    }
}
