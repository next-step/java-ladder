package nextstep.ladder.domain;

import java.util.List;
import java.util.function.Consumer;

public class Persons {

    private final List<Person> persons;

    public Persons(List<Person> persons) {
        this.persons = persons;
    }

    public int indexOfPerson(String name) {
        for (int i = 0; i < persons.size(); i++) {
            Person person = persons.get(i);
            if (person.getName().equals(name)) {
                return i;
            }
        }

        throw new IllegalArgumentException("존재하지 않는 참가자입니다.");
    }

    public int size() {
        return persons.size();
    }

    public void forEach(Consumer<Person> action) {
        for (Person person : persons) {
            action.accept(person);
        }
    }


}
