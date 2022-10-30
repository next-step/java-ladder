package nextstep.ladder;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Person {

    List<String> person;

    public Person(String[] person) {
        this.person = Arrays.asList(person);
    }

    public int countPerson() {
        return person.size();
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
