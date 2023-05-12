package laddergame.domain;

public class Person {

    private final String name;

    public Person(final String name) {
        validationLength(name.length());
        this.name = name;
    }

    private void validationLength(final int length) {
        if (length > 5) {
            throw new IllegalArgumentException("이름은 최대 5글자여야 합니다.");
        }
    }
}
