package ladder;

import java.util.Objects;

public class Person {
    private final int index;
    private final String name;

    public Person(int index, String name) {
        this.index = index;
        this.name = name;
    }

    public Person(String name) {
        this(-1, name);
    }

    public int getIndex() {
        return index;
    }

    public String getName() {
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
