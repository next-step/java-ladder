package nextstep.domain;

import java.util.Objects;

public class Person {

    private final String name;

    public Person(String name) {
        if (!validateName(name)) {
            throw new IllegalArgumentException("유효하지 않은 이름입니다.");
        }
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static boolean validateName(String name) {
        return PersonValidator.validateName(name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
