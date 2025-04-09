package nextstep.ladder;

public class Person {
    private static final int MAX_NAME_LENGTH = 5;

    public String name;

    public Person(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        validateEmpty(name);
        validateLength(name);
    }

    private static void validateLength(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 5자 이하이어야 합니다.");
        }
    }

    private static void validateEmpty(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("이름은 null 또는 빈 문자열일 수 없습니다.");
        }
    }

    public String toString() {
        return name;
    }
}
