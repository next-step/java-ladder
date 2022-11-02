package nextstep.ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {

    private List<String> people = new ArrayList<>();

    public Person(String[] people) {
        for (String person : people) {
            checkDuplicate(person);
            checkNameLength(person);
            this.people.add(person);
        }
    }

    private void checkNameLength(String person) {
        if (person.length() > 5) {
            throw new IllegalArgumentException("이름은 5자까지 입력 가능합니다.");
        }
    }

    private void checkDuplicate(String person) {
        if (this.people.contains(person)) {
            throw new IllegalArgumentException("이름은 중복으로 입력 불가합니다.");
        }
    }

    public int countPerson() {
        return people.size();
    }

    public List<String> getPerson() {
        return people;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person1 = (Person) o;
        return Objects.equals(people, person1.people);
    }

    @Override
    public int hashCode() {
        return Objects.hash(people);
    }
}
