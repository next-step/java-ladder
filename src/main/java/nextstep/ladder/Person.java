package nextstep.ladder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Person {

    List<String> person = new ArrayList<>();

    public Person(String[] person) {
        this.person = Arrays.asList(person);
    }

    public List<String> getPerson() {
        return person;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person1 = (Person) o;
        return Objects.equals(person, person1.person);
    }

    @Override
    public int hashCode() {
        return Objects.hash(person);
    }
}
