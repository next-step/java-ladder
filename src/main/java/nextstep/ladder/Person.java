package nextstep.ladder;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Person {

    List<String> person = new ArrayList<>();

    public Person(String[] people) {
        for (String person : people) {
            checkDuplicate(person);
            this.person.add(person);
        }
    }

    private void checkDuplicate(String person) {
        if (this.person.contains(person)) {
            throw new IllegalArgumentException("이름은 중복으로 입력 불가합니다.");
        }
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
