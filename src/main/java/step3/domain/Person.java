package step3.domain;

import java.util.Objects;

public class Person {
    private static final String OVER_FINE_LETTER = "참가자 이름은 다섯 글자를 초과할 수 없습니다.";
    private static final String UNDER_ONE_LETTER = "참가자 이름은 한 글자 미만으로 입력 할 수 없습니다.";
    private static final int OVER_LETTER = 5;
    private static final int UNDER_LETTER = 1;
    private final String name;

    public Person(String name) {
        validateFiveLetter(name);
        this.name = name;
    }

    void validateFiveLetter(String name) {
        if (name.length() > OVER_LETTER) {
            throw new IllegalArgumentException(OVER_FINE_LETTER);
        }

        if (name.length() < UNDER_LETTER) {
            throw new IllegalArgumentException(UNDER_ONE_LETTER);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person that = (Person) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return name + "";

    }
}
