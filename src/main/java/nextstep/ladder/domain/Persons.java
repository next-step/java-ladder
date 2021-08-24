package nextstep.ladder.domain;

import java.util.List;
import java.util.function.Consumer;

public class Persons {

    private final List<Person> persons;

    private Persons(List<Person> persons) {
        this.persons = persons;
    }

    public static Persons of(List<Person> gamers) {
        if (gamers.size() < 2) {
            throw new IllegalArgumentException("참가자는 최소 두명 이상이여야 합니다.");
        }

        return new Persons(gamers);
    }

    public int findIndexOfPerson(String name) {
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
