package laddergame.domain.person;

public class Person {

    private final String name;

    private static final int MAX_NAME_LENGTH = 5;

    public Person(final String name) {
        validateLengthOfName(name.length());
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validateLengthOfName(final int length) {
        if (length > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("이름은 최대 5글자여야 합니다.");
        }
    }
}
