package nextstep.ladder.model;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Person {

    private final Name name;

    private Person(Name name) {
        this.name = name;
    }

    public static Person of(String name) {
        return new Person(Name.of(name));
    }

    public static List<Person> of(List<String> names) {
        return names
                .stream()
                .map(Person::of)
                .collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return this.name.toString();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(this.name, person.name);
    }

    public boolean equals(String name) {
        return this.name.equals(name);
    }
}
