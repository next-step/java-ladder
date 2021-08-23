package nextstep.ladder.domain;

import java.util.Objects;

public class Person {

    public static final int MAX_NAME_LENGTH = 5;
    private final String name;

    private Person(String name) {
        this.name = name;
    }

    public static Person of(String name) {
        if (name.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException("5자리이 이하로 입력해주세요");
        }

        return new Person(addNameWithBlank(name));
    }

    private static String addNameWithBlank(String name) {
        StringBuilder nameBuilder = new StringBuilder(name);

        while (nameBuilder.length() < MAX_NAME_LENGTH) {
            nameBuilder.append(" ");
        }

        return nameBuilder.toString();
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
