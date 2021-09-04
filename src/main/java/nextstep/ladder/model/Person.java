package nextstep.ladder.model;

import java.util.Objects;

public class Person {
    public static final int NAME_MAX_SIZE = 5;
    private String name;

    public Person(String name) {
        String trimmingName = name.trim();
        if (trimmingName.length() > NAME_MAX_SIZE) {
            throw new IllegalArgumentException("이름이 너무 깁니다. ");
        }

        if ("".equals(trimmingName)) {
            throw new IllegalArgumentException("이름이 비어있습니다.");
        }

        this.name = trimmingName;
    }

    @Override
    public String toString() {
        return name;
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
