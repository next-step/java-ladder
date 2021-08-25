package nextstep.ladder.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class Persons {

    public static final int MIN_PERSON_SIZE = 2;
    private final Map<Person, Integer> persons;

    private Persons(Map<Person, Integer> persons) {
        this.persons = persons;
    }

    public static Persons of(List<Person> gamers) {
        if (gamers.size() < MIN_PERSON_SIZE) {
            throw new IllegalArgumentException("참가자는 최소 두명 이상이여야 합니다.");
        }

        Map<Person, Integer> persons = new HashMap<>();

        for (int i = 0; i < gamers.size(); i++) {
            Person person = gamers.get(i);
            persons.put(person, i);
        }

        return new Persons(persons);
    }

    public int findIndexOfPerson(String name) {
        Person person = Person.of(name);

        if (persons.containsKey(person)) {
            return persons.get(person);
        }

        throw new IllegalArgumentException("존재하지 않는 참가자입니다.");
    }

    public int size() {
        return persons.size();
    }

    public void forEach(Consumer<Person> action) {
        persons.keySet().forEach(action);
    }


}
