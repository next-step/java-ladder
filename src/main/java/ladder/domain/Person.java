package ladder.domain;

import java.util.Objects;

public class Person {
    private final Name name;

    private Person(String name) {
        this.name = Name.of(name);
    }

    public static Person of(String name) {
        return new Person(name);
    }

    public Name getName() {
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
