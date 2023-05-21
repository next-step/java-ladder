package ladder.domain;

public class Person {
    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    public Person(String name) {
        validateName(name);

        this.name = name.trim();
    }

    private void validateName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("이름이 Null 또는 빈값이 입력되었습니다.");
        }

        if (name.trim().length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름이 최대허용길이(" + MAX_NAME_LENGTH + ")를 초과하였습니다");
        }
    }

    @Override
    public String toString() {
        return this.name;
    }

    @Override
    public boolean equals(Object obj) {
        return this.name.equals(obj);
    }
}
