package Ladder;

import java.util.Objects;

public class Person {
    // private static final Map<String, Person> PERSON = new HashMap<>();
    private static final int MAX_NAME_LENGTH = 5;
    private String name;

    public Person(String name) throws Exception {
        this.name = name;
        if (this.name.length() > MAX_NAME_LENGTH) {
            throw new Exception();
        }
    }

    @Override
    public String toString() {
        return name;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
